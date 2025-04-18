package com.gustavo.gestao_api_rest.services;

import com.gustavo.gestao_api_rest.dto.DemandaDTO;
import com.gustavo.gestao_api_rest.dto.FuncionarioDTO;
import com.gustavo.gestao_api_rest.entities.Demanda;
import com.gustavo.gestao_api_rest.entities.Funcionario;
import com.gustavo.gestao_api_rest.entities.Setor;
import com.gustavo.gestao_api_rest.repositories.DemandaRepository;
import com.gustavo.gestao_api_rest.repositories.FuncionarioRepository;
import com.gustavo.gestao_api_rest.repositories.SetorRepository;
import com.gustavo.gestao_api_rest.services.exceptions.DatabaseException;
import com.gustavo.gestao_api_rest.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    public FuncionarioRepository funcionarioRepository;

    @Autowired
    public DemandaRepository demandaRepository;

    @Autowired
    public SetorRepository setorRepository;

    @Transactional(readOnly = true)
    public FuncionarioDTO procurarPorId(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Funcionário não encontrado."));
        return new FuncionarioDTO(funcionario);
    }

    @Transactional(readOnly = true)
    public List<FuncionarioDTO> buscarTodos() {
        List<Funcionario> result = funcionarioRepository.findAll();
        return result.stream()
                .map(x -> new FuncionarioDTO(x))
                .toList();
    }

    @Transactional
    public FuncionarioDTO inserirFuncionario(FuncionarioDTO dto) {

        Funcionario entity = new Funcionario();
        copyDtoToEntity(dto, entity);

        Setor setor = setorRepository.getReferenceById(dto.getSetor().getId());

        for(DemandaDTO demandaDTO : dto.getDemandas()) {
            Demanda demanda = demandaRepository.getReferenceById(demandaDTO.getId());
            entity.getDemandas().add(demanda);
        }

        entity.setSetor(setor);

        entity = funcionarioRepository.save(entity);

        return new FuncionarioDTO(entity);
    }

    @Transactional
    public FuncionarioDTO atualizarFuncionario(Long id, FuncionarioDTO dto) {
        Funcionario entity = funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado"));

        copyDtoToEntity(dto, entity);

        if (dto.getSetor() != null && dto.getSetor().getId() != null) {
            Setor setor = setorRepository.findById(dto.getSetor().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Setor não encontrado"));
            entity.setSetor(setor);
        }

        if (dto.getDemandas() != null && !dto.getDemandas().isEmpty()) {
            List<Demanda> demandas = new ArrayList<>();
            for (DemandaDTO demandaDTO : dto.getDemandas()) {
                if (demandaDTO.getId() != null) {
                    Demanda demanda = demandaRepository.findById(demandaDTO.getId())
                            .orElseThrow(() -> new ResourceNotFoundException("Demanda não encontrada."));
                    demandas.add(demanda);
                }
            }
            entity.setDemandas(new HashSet<>(demandas));

            entity = funcionarioRepository.save(entity);
            return new FuncionarioDTO(entity);
        }


        return new FuncionarioDTO(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deletarFuncionario(Long id) {
        if(!funcionarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Funcionário não existe.");
        } try {
            funcionarioRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial.");
        }
        funcionarioRepository.deleteById(id);
    }

    private void copyDtoToEntity(FuncionarioDTO dto, Funcionario entity) {
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEndereco(dto.getEndereco());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setEmailPessoal(dto.getEmailPessoal());
        entity.setEmailWorkspace(dto.getEmailWorkspace());
        entity.setTelefone(dto.getTelefone());
    }
}

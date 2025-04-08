package com.gustavo.gestao_api_rest.services;

import com.gustavo.gestao_api_rest.dto.EquipamentoDTO;
import com.gustavo.gestao_api_rest.dto.EquipamentoMinDTO;
import com.gustavo.gestao_api_rest.entities.Equipamento;
import com.gustavo.gestao_api_rest.entities.Funcionario;
import com.gustavo.gestao_api_rest.entities.Setor;
import com.gustavo.gestao_api_rest.repositories.EquipamentoRepository;
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

import java.util.List;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private SetorRepository setorRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Transactional(readOnly = true)
    public EquipamentoDTO procurarPorId(Long id) {
        Equipamento equipamento = equipamentoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Equipamento não encontrado."));
        return new EquipamentoDTO(equipamento);
    }

    @Transactional(readOnly = true)
    public List<EquipamentoMinDTO> searchByName(String tipo) {
        List<Equipamento> result =equipamentoRepository.searchByName(tipo);
        return result.stream().map(x -> new EquipamentoMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public List<EquipamentoDTO> buscarTodos() {
        List<Equipamento> result = equipamentoRepository.findAll();
        return result.stream()
                .map(x -> new EquipamentoDTO(x))
                .toList();
    }

    @Transactional
    public EquipamentoDTO inserirEquipamento(EquipamentoDTO dto) {
        Equipamento entity = new Equipamento();
        copyDtoToEntity(dto, entity);

        Setor setor = setorRepository.getReferenceById(dto.getSetor().getId());
        entity.setSetor(setor);

        if (dto.getFuncionario() != null && dto.getFuncionario().getId() != null) {
            Funcionario funcionario = funcionarioRepository.getReferenceById(dto.getFuncionario().getId());
            entity.setFuncionario(funcionario);
        }

        entity = equipamentoRepository.save(entity);
        return new EquipamentoDTO(entity);
    }

    @Transactional
    public EquipamentoDTO atualizarEquipamento(Long id, EquipamentoDTO dto) {
        Equipamento entity = equipamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipamento não encontrado."));

        copyDtoToEntity(dto, entity);

        if (dto.getSetor() != null && dto.getSetor().getId() != null) {
            Setor setor = setorRepository.findById(dto.getSetor().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Setor não encontrado."));
            entity.setSetor(setor);
        }

        if (dto.getFuncionario() != null && dto.getFuncionario().getId() != null) {
            Funcionario funcionario = funcionarioRepository.findById(dto.getFuncionario().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado."));
            entity.setFuncionario(funcionario);
        } else {
            entity.setFuncionario(null);
        }

        entity = equipamentoRepository.save(entity);
        return new EquipamentoDTO(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deletarEquipamento(Long id) {
        if (!equipamentoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Equipamento não existe.");
        } try {
            equipamentoRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial.");
        }
        equipamentoRepository.deleteById(id);
    }

    private void copyDtoToEntity(EquipamentoDTO dto, Equipamento entity) {
        entity.setPatrimonio(dto.getPatrimonio());
        entity.setTipo(dto.getTipo());
        entity.setModelo(dto.getModelo());
        entity.setDescricao(dto.getDescricao());
    }
}

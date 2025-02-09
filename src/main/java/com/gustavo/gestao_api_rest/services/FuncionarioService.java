package com.gustavo.gestao_api_rest.services;

import com.gustavo.gestao_api_rest.dto.FuncionarioDTO;
import com.gustavo.gestao_api_rest.entities.Funcionario;
import com.gustavo.gestao_api_rest.repositories.FuncionarioRepository;
import com.gustavo.gestao_api_rest.services.exceptions.DatabaseException;
import com.gustavo.gestao_api_rest.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FuncionarioService {

    @Autowired
    public FuncionarioRepository funcionarioRepository;

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
        entity = funcionarioRepository.save(entity);
        return new FuncionarioDTO(entity);
    }

    @Transactional
    public FuncionarioDTO atualizarFuncionario(Long id, FuncionarioDTO dto) {
        try {
            Funcionario entity = funcionarioRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = funcionarioRepository.save(entity);
            return new FuncionarioDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Funcionário não encontrado.");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deletarFuncionario(Long id) {
        if(!funcionarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Funcionário não existe");
        } try {
            funcionarioRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
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

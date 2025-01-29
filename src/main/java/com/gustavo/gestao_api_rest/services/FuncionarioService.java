package com.gustavo.gestao_api_rest.services;

import com.gustavo.gestao_api_rest.dto.FuncionarioDTO;
import com.gustavo.gestao_api_rest.entities.Funcionario;
import com.gustavo.gestao_api_rest.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    public FuncionarioRepository funcionarioRepository;

    @Transactional(readOnly = true)
    public FuncionarioDTO buscarPorId(Long id) throws ChangeSetPersister.NotFoundException {
        try {
            Funcionario result = funcionarioRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Funcionário com ID " + id + " não encontrado."));
            return new FuncionarioDTO(result);
        } catch (NoSuchElementException e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<FuncionarioDTO> buscarTodos() {
        List<Funcionario> result = funcionarioRepository.findAll();
        return result.stream().map(x -> new FuncionarioDTO(x)).toList();
    }

    @Transactional
    public FuncionarioDTO criarFuncionario(FuncionarioDTO dto) {
        Funcionario entity = new Funcionario(dto);
        entity = funcionarioRepository.save(entity);
        return new FuncionarioDTO(entity);
    }

    @Transactional
    public FuncionarioDTO atualizarFuncionario(Long id, FuncionarioDTO dto) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Funcionário não encontrado."));
        funcionario.setNome(dto.getNome());
        funcionario.setEmailWorkspace(dto.getEmailWorkspace());
        funcionario.setSetor(dto.getSetor());
        funcionario = funcionarioRepository.save(funcionario);
        return new FuncionarioDTO(funcionario);
    }

    @Transactional
    public void deletarFuncionario(Long id) {
        Optional<Funcionario> optional = funcionarioRepository.findById(id);
        if(optional.isPresent()) {
            funcionarioRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Esse funcionário não existe.");
        }
    }

    /*
    @Transactional
    public void deletarFuncionario(Long id) {
        if (funcionarioRepository.existsById(id)) {
            funcionarioRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Funcionário não encontrado.");
        }
    } */
}

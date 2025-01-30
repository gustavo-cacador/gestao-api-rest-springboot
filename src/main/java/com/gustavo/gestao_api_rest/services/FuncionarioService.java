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
}

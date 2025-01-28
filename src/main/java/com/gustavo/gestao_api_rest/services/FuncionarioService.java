package com.gustavo.gestao_api_rest.services;

import com.gustavo.gestao_api_rest.dto.FuncionarioDTO;
import com.gustavo.gestao_api_rest.entities.Funcionario;
import com.gustavo.gestao_api_rest.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    public FuncionarioRepository funcionarioRepository;

    public FuncionarioDTO buscarPorId(Long id) {
        Funcionario result = funcionarioRepository.findById(id).get();
        // Adicionar try para caso não exista o Id
        return new FuncionarioDTO(result);
    }

    public List<FuncionarioDTO> buscarTodos() {
        List<Funcionario> result = funcionarioRepository.findAll();
        return result.stream().map(x -> new FuncionarioDTO(x)).toList();
    }

    public Optional<Funcionario> buscarPorNomeUnico(String nome) {
        return funcionarioRepository.findByNomeLike(nome);
    }
}

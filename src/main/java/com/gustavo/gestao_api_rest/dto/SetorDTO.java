package com.gustavo.gestao_api_rest.dto;

import com.gustavo.gestao_api_rest.entities.Setor;

import java.util.List;
import java.util.stream.Collectors;

public class SetorDTO {

    private Long id;
    private String nome;
    private List<FuncionarioDTO> funcionarios;

    public SetorDTO() {

    }

    public SetorDTO(Setor entity) {
        id = entity.getId();
        nome = entity.getNome();
        funcionarios = entity.getFuncionarios().stream()
                .map(funcionario -> new FuncionarioDTO(funcionario))
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<FuncionarioDTO> getFuncionarios() {
        return funcionarios;
    }
}

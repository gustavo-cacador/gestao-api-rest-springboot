package com.gustavo.gestao_api_rest.dto;

import com.gustavo.gestao_api_rest.entities.Funcionario;

public class FuncionarioMinDTO {

    private Long id;
    private String nome;
    private String cpf;

    public FuncionarioMinDTO() {
    }

    public FuncionarioMinDTO(Long id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public FuncionarioMinDTO(Funcionario entity) {
        id = entity.getId();
        nome = entity.getNome();
        cpf = entity.getCpf();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}

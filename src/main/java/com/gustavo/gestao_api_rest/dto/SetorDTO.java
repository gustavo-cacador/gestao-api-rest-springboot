package com.gustavo.gestao_api_rest.dto;

import com.gustavo.gestao_api_rest.entities.Setor;

import java.util.List;
import java.util.stream.Collectors;

public class SetorDTO {

    private Long id;
    private String nome;
    private String descricao;

    public SetorDTO() {
    }

    public SetorDTO(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public SetorDTO(Setor entity) {
        id = entity.getId();
        nome = entity.getNome();
        descricao = entity.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}

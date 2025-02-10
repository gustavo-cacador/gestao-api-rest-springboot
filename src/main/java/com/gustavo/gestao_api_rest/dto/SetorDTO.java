package com.gustavo.gestao_api_rest.dto;

import com.gustavo.gestao_api_rest.entities.Setor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.stream.Collectors;

public class SetorDTO {

    private Long id;

    @Size(min = 3, max = 80, message = "Nome não pode ser vazio.")
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @Size(min = 3, max = 250, message = "Descrição deve conter entre 3 e 150 caracteres.")
    @NotBlank(message = "A descrição é obrigatória.")
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

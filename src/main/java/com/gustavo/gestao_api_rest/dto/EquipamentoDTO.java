package com.gustavo.gestao_api_rest.dto;

import com.gustavo.gestao_api_rest.entities.Equipamento;
import com.gustavo.gestao_api_rest.entities.Funcionario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class EquipamentoDTO {

    private Long id;

    @NotNull(message = "O patrimônio é obrigatório.")
    private Integer patrimonio;

    @Size(min = 3, max = 30, message = "Tipo do equipamento precisa ter entre 3 a 30 caracteres.")
    @NotBlank(message = "O tipo do equipamento é obrigatório.")
    private String tipo;

    @Size(min = 3, max = 80, message = "Tipo do equipamento precisa ter entre 3 a 80 caracteres.")
    @NotBlank(message = "O tipo do modelo é obrigatório.")
    private String modelo;

    private String descricao;

    @NotNull(message = "O setor eh obrigatório.")
    private SetorDTO setor;

    public EquipamentoDTO() {
    }

    public EquipamentoDTO(Long id, Integer patrimonio, String tipo, String modelo, String descricao) {
        this.id = id;
        this.patrimonio = patrimonio;
        this.tipo = tipo;
        this.modelo = modelo;
        this.descricao = descricao;
    }

    public EquipamentoDTO(Equipamento entity) {
        id = entity.getId();
        patrimonio = entity.getPatrimonio();
        tipo = entity.getTipo();
        modelo = entity.getModelo();
        descricao = entity.getDescricao();
        setor = (entity.getSetor() == null) ? null : new SetorDTO(entity.getSetor());
    }

    public Long getId() {
        return id;
    }

    public Integer getPatrimonio() {
        return patrimonio;
    }

    public String getTipo() {
        return tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public SetorDTO getSetor() {
        return setor;
    }
}

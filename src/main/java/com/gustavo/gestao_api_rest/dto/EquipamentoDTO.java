package com.gustavo.gestao_api_rest.dto;

import com.gustavo.gestao_api_rest.entities.Equipamento;

public class EquipamentoDTO {

    private Long id;
    private Integer patrimonio;
    private String tipo;
    private String modelo;
    private String descricao;

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
}

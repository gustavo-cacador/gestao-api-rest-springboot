package com.gustavo.gestao_api_rest.dto;

import com.gustavo.gestao_api_rest.entities.Equipamento;

public class EquipamentoMinDTO {

    private Long id;
    private Integer patrimonio;
    private String tipo;
    private String modelo;

    public EquipamentoMinDTO() {
    }

    public EquipamentoMinDTO(Long id, Integer patrimonio, String tipo, String modelo) {
        this.id = id;
        this.patrimonio = patrimonio;
        this.tipo = tipo;
        this.modelo = modelo;
    }

    public EquipamentoMinDTO(Equipamento entity) {
        id = entity.getId();
        patrimonio = entity.getPatrimonio();
        tipo = entity.getTipo();
        modelo = entity.getModelo();
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
}

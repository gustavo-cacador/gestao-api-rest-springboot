package com.gustavo.gestao_api_rest.dto;

import com.gustavo.gestao_api_rest.entities.Equipamento;

public class EquipamentoDTO {

    private Long id;
    private String tipo;

    public EquipamentoDTO() {

    }

    public EquipamentoDTO(Equipamento entity) {
        id = entity.getId();
        tipo = entity.getTipo();
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }
}

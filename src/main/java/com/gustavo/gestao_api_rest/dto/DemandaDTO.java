package com.gustavo.gestao_api_rest.dto;

import com.gustavo.gestao_api_rest.entities.Demanda;


import java.util.Date;

public class DemandaDTO {

    private Long id;
    private String pendencia;
    private String situacao;
    private Date prazo;
    private String canal;

    public DemandaDTO() {

    }

    public DemandaDTO(Demanda entity) {
        id = entity.getId();
        pendencia = entity.getPendencia();
        situacao = entity.getSituacao();
        prazo = entity.getPrazo();
        canal = entity.getCanal();
    }

    public Long getId() {
        return id;
    }

    public String getPendencia() {
        return pendencia;
    }

    public String getSituacao() {
        return situacao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public String getCanal() {
        return canal;
    }

}

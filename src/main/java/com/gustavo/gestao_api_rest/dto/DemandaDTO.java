package com.gustavo.gestao_api_rest.dto;

import com.gustavo.gestao_api_rest.entities.Demanda;


import java.util.Date;

public class DemandaDTO {

    private Long id;

    private String pendencia;
    private String servico;
    private Date dataAbertura;
    private Integer nivel;
    private Date prazo;
    private String canal;

    public DemandaDTO() {
    }

    public DemandaDTO(Long id, String pendencia, String servico, Date dataAbertura, Integer nivel, Date prazo, String canal) {
        this.id = id;
        this.pendencia = pendencia;
        this.servico = servico;
        this.dataAbertura = dataAbertura;
        this.nivel = nivel;
        this.prazo = prazo;
        this.canal = canal;
    }

    public DemandaDTO(Demanda entity) {
        id = entity.getId();
        pendencia = entity.getPendencia();
        servico = entity.getServico();
        dataAbertura = entity.getDataAbertura();
        nivel = entity.getNivel();
        prazo = entity.getPrazo();
        canal = entity.getCanal();
    }

    public Long getId() {
        return id;
    }

    public String getPendencia() {
        return pendencia;
    }

    public String getServico() {
        return servico;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public Integer getNivel() {
        return nivel;
    }

    public Date getPrazo() {
        return prazo;
    }

    public String getCanal() {
        return canal;
    }
}

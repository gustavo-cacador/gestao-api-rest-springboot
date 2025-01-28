package com.gustavo.gestao_api_rest.dto;

import com.gustavo.gestao_api_rest.entities.Demanda;
import com.gustavo.gestao_api_rest.entities.Funcionario;


import java.time.LocalDate;

public class DemandaDTO {

    private Long id;
    private String funcionarioNome;
    private String pendencia;
    private String situacao;
    private LocalDate prazo;
    private String canal;
    private String solicitante;

    public DemandaDTO() {

    }

    public DemandaDTO(Demanda entity) {
        id = entity.getId();
        funcionarioNome = entity.getFuncionario() != null ? entity.getFuncionario().getNome() : null;
        pendencia = entity.getPendencia();
        situacao = entity.getSituacao();
        prazo = entity.getPrazo();
        canal = entity.getCanal();
        solicitante = entity.getSolicitante();
    }

    public Long getId() {
        return id;
    }

    public String getFuncionarioNome() {
        return funcionarioNome;
    }

    public String getPendencia() {
        return pendencia;
    }

    public String getSituacao() {
        return situacao;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public String getCanal() {
        return canal;
    }

    public String getSolicitante() {
        return solicitante;
    }
}

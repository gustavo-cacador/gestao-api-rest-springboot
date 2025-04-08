package com.gustavo.gestao_api_rest.dto;

import com.gustavo.gestao_api_rest.entities.Demanda;
import com.gustavo.gestao_api_rest.entities.Funcionario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DemandaDTO {

    private Long id;

    @Size(min = 3, max = 200, message = "Pendência não pode ser vazia.")
    @NotBlank(message = "A pendência é obrigatória.")
    private String pendencia;

    @NotBlank(message = "O setor destinado ao serviço é obrigatório.")
    private String servico;

    private Date dataAbertura;

    private Integer nivel;
    private Date prazo;

    @NotBlank(message = "O tipo de canal é obrigatório.")
    private String canal;

    @NotEmpty(message = "Deve ter pelo menos um funcionário")
    private List<FuncionarioMinDTO> funcionarios = new ArrayList<>();

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
        funcionarios = entity.getFuncionarios()
                .stream()
                .map(FuncionarioMinDTO::new)
                .collect(Collectors.toList());
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

    public List<FuncionarioMinDTO> getFuncionarios() {
        return funcionarios;
    }
}

package com.gustavo.gestao_api_rest.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_demanda")
public class Demanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pendencia; // Descrever a demanda que vai realizar
    private String situacao; // Concluido, Em andamento, Aberto
    private String servico; // Serviço prestado por qual setor
    private Date dataAbertura; // Dia em que começou a fazer a task
    private Integer nivel; // nivel 1 = 1 dia, nivel 7 = 7 dias, nivel 30 = 30 dias
    private Date prazo; // prazo depende do nivel da task
    private String canal; // Email, Whatsapp, Remoto, Presencial, Interno

    //private String solicitante; // Nome do funcionario que solicitou a task (pode ser um chef)
    //private String emailSolicitante; // Email do funcionario que solicitou a task

    @ManyToMany(mappedBy = "demandas")
    private Set<Funcionario> funcionarios = new HashSet<>();

    public Demanda() {

    }

    public Demanda(Long id, String pendencia, String situacao, String servico, Date dataAbertura, Integer nivel, Date prazo, String canalr) {
        this.id = id;
        this.pendencia = pendencia;
        this.situacao = situacao;
        this.servico = servico;
        this.dataAbertura = dataAbertura;
        this.nivel = nivel;
        this.prazo = prazo;
        this.canal = canal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPendencia() {
        return pendencia;
    }

    public void setPendencia(String pendencia) {
        this.pendencia = pendencia;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    /*
    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getEmailSolicitante() {
        return emailSolicitante;
    }

    public void setEmailSolicitante(String emailSolicitante) {
        this.emailSolicitante = emailSolicitante;
    }

     */
    }

package com.gustavo.gestao_api_rest.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tb_demanda")
public class Demanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pendencia")
    private String pendencia; // Descrever a demanda que vai realizar

    @Column(name = "situacao")
    private String situacao; // Concluido, Em andamento, Aberto

    @Column(name = "servico")
    private String servico; // Serviço prestado por qual setor

    @Column(name = "data_abertura")
    private Date dataAbertura; // Dia em que começou a fazer a task

    @Column(name = "nivel")
    private Integer nivel; // nivel 1 = 1 dia, nivel 7 = 7 dias, nivel 30 = 30 dias

    @Column(name = "prazo")
    private Date prazo; // prazo depende do nivel da task

    @Column(name = "canal")
    private String canal; // Email, Whatsapp, Remoto, Presencial, Interno

    //private String solicitante; // Nome do funcionario que solicitou a task (pode ser um chef)
    //private String emailSolicitante; // Email do funcionario que solicitou a task

    @ManyToOne
    @JoinColumn(name = "solicitante_id")
    private Funcionario solicitante; // Funcionario que solicitou a demanda

    @ManyToOne
    @JoinColumn(name = "executor_id")
    private Funcionario executor; // Funcionario que solicitou a demanda

    public Demanda() {

    }

    public Demanda(Long id, String pendencia, String situacao, String servico, Date dataAbertura, Integer nivel, Date prazo, String canal, Funcionario solicitante, Funcionario executor) {
        this.id = id;
        this.pendencia = pendencia;
        this.situacao = situacao;
        this.servico = servico;
        this.dataAbertura = dataAbertura;
        this.nivel = nivel;
        this.prazo = prazo;
        this.canal = canal;
        this.solicitante = solicitante;
        this.executor = executor;
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

    public Funcionario getExecutor() {
        return executor;
    }

    public void setExecutor(Funcionario executor) {
        this.executor = executor;
    }

    public Funcionario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Funcionario solicitante) {
        this.solicitante = solicitante;
    }
    }

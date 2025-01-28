package com.gustavo.gestao_api_rest.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_demanda")
public class Demanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario; // Demanda associada a qual funcionario

    private String pendencia; // Descrever a demanda que vai realizar
    private String situacao; // Concluido, Em andamento, Aberto
    private String servico; // Serviço prestado por qual setor
    private LocalDate dataAbertura; // Dia em que começou a fazer a task
    private int nivel; // nivel 1 = 1 dia, nivel 7 = 7 dias, nivel 30 = 30 dias
    private LocalDate prazo; // prazo depende do nivel da task
    private String canal; // Email, Whatsapp, Remoto, Presencial, Interno
    private String solicitante; // Nome do funcionario que solicitou a task (pode ser um chef)
    private String emailSolicitante; // Email do funcionario que solicitou a task

    public Demanda() {

    }

    public Demanda(Long id, Funcionario funcionario, String pendencia, String situacao, String servico, LocalDate dataAbertura, int nivel, LocalDate prazo, String canal, String solicitante, String emailSolicitante) {
        this.id = id;
        this.funcionario = funcionario;
        this.pendencia = pendencia;
        this.situacao = situacao;
        this.servico = servico;
        this.dataAbertura = dataAbertura;
        this.nivel = nivel;
        this.prazo = prazo;
        this.canal = canal;
        this.solicitante = solicitante;
        this.emailSolicitante = emailSolicitante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

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
}

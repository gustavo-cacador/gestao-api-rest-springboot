package com.gustavo.gestao_api_rest.entities;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer patrimonio;
    private String tipo; // Computador, Monitor, Nobreak, Suporte
    private String modelo;
    private String descricao; // Caso precise fazer alguma observação (Ex: sem número do patrimonio do monitor)

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario; // funcionario associado ao equipamento

    @ManyToOne
    @JoinColumn(name = "setor_id")
    private Setor setor;

    public Equipamento() {

    }

    public Equipamento(Long id, Integer patrimonio, String tipo, String modelo, String descricao, Funcionario funcionario, Setor setor) {
        this.id = id;
        this.patrimonio = patrimonio;
        this.tipo = tipo;
        this.modelo = modelo;
        this.descricao = descricao;
        this.funcionario = funcionario;
        this.setor = setor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Equipamento that = (Equipamento) o;
        return Objects.equals(id, that.id) && Objects.equals(patrimonio, that.patrimonio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patrimonio);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(Integer patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}

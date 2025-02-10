package com.gustavo.gestao_api_rest.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_setor")
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @OneToMany(mappedBy = "setor")
    private List<Funcionario> funcionarios = new ArrayList<>();

    @OneToMany(mappedBy = "setor")
    private List<Equipamento> equipamentos = new ArrayList<>();

    public Setor() {

    }

    public Setor(Long id, String nome, String descricao, List<Funcionario> funcionarios, List<Equipamento> equipamentos) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.funcionarios = funcionarios;
        this.equipamentos = equipamentos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Setor setor = (Setor) o;
        return Objects.equals(id, setor.id) && Objects.equals(nome, setor.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }
}

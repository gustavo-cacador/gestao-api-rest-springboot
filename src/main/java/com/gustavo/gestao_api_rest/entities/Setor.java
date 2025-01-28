package com.gustavo.gestao_api_rest.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_setor")
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "setor")
    private List<Funcionario> funcionarios;

    private String descricao;

    public Setor() {

    }

    public Setor(Long id, String nome, List<Funcionario> funcionarios, String descricao) {
        this.id = id;
        this.nome = nome;
        this.funcionarios = funcionarios;
        this.descricao = descricao;
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

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

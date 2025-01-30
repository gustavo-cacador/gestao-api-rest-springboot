package com.gustavo.gestao_api_rest.dto;

import com.gustavo.gestao_api_rest.entities.Funcionario;
import com.gustavo.gestao_api_rest.entities.Setor;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class FuncionarioDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String endereco;
    private Date dataNascimento;
    private String emailPessoal;
    private String emailWorkspace;
    private String telefone;
    private Setor setor;

    public FuncionarioDTO() {

    }

    public FuncionarioDTO(Funcionario entity) {
        BeanUtils.copyProperties(entity, this);
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmailPessoal() {
        return emailPessoal;
    }

    public void setEmailPessoal(String emailPessoal) {
        this.emailPessoal = emailPessoal;
    }

    public String getEmailWorkspace() {
        return emailWorkspace;
    }

    public void setEmailWorkspace(String emailWorkspace) {
        this.emailWorkspace = emailWorkspace;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}


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

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(Long id, String nome, String cpf, String endereco, Date dataNascimento, String emailPessoal, String emailWorkspace, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.emailPessoal = emailPessoal;
        this.emailWorkspace = emailWorkspace;
        this.telefone = telefone;
    }

    public FuncionarioDTO(Funcionario entity) {
        id = entity.getId();
        nome = entity.getNome();
        cpf = entity.getCpf();
        endereco = entity.getEndereco();
        dataNascimento = entity.getDataNascimento();
        emailPessoal = entity.getEmailPessoal();
        emailWorkspace = entity.getEmailWorkspace();
        telefone = entity.getTelefone();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getEmailPessoal() {
        return emailPessoal;
    }

    public String getEmailWorkspace() {
        return emailWorkspace;
    }

    public String getTelefone() {
        return telefone;
    }
}


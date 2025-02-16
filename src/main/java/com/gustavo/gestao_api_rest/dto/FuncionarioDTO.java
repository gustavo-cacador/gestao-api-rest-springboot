package com.gustavo.gestao_api_rest.dto;

import com.gustavo.gestao_api_rest.entities.Demanda;
import com.gustavo.gestao_api_rest.entities.Funcionario;
import com.gustavo.gestao_api_rest.entities.Setor;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FuncionarioDTO {

    private Long id;

    @Size(min = 3, max = 80, message = "Nome não pode ser vazio.")
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @Size(min = 11, max = 11, message = "CPF tem que conter 11 caracteres")
    @NotBlank(message = "O CPF é obrigatório.")
    private String cpf;

    @Size(min = 3, max = 250, message = "Endereço não pode ser vazio.")
    @NotBlank(message = "O endereço é obrigatório.")
    private String endereco;

    @NotNull(message = "A data de nascimento é obrigatória.")
    @PastOrPresent(message = "A data de nascimento não pode estar no futuro.")
    private Date dataNascimento;

    @Email(message = "O email pessoal deve ser válido.")
    private String emailPessoal;

    @Email(message = "O email corporativo deve ser válido.")
    private String emailWorkspace;

    @Size(min = 11, max = 11, message = "Telefone não pode ser vazio.")
    @NotBlank(message = "O telefone é obrigatório.")
    private String telefone;

    private Long setorId;

    private List<DemandaDTO> demandas = new ArrayList<>();

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(Long id, String nome, String cpf, String endereco, Date dataNascimento, String emailPessoal, String emailWorkspace, String telefone, Long setorId) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.emailPessoal = emailPessoal;
        this.emailWorkspace = emailWorkspace;
        this.telefone = telefone;
        this.setorId = setorId;
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
        setorId = entity.getSetor().getId();
        for (Demanda demanda : entity.getDemandas()) {
            demandas.add(new DemandaDTO(demanda));
        }
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

    public Long getSetorId() {
        return setorId;
    }

    public List<DemandaDTO> getDemandas() {
        return demandas;
    }
}


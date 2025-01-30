package com.gustavo.gestao_api_rest.dto;

import com.gustavo.gestao_api_rest.entities.Funcionario;
import com.gustavo.gestao_api_rest.entities.Setor;
import com.gustavo.gestao_api_rest.projections.FuncionarioMinProjection;

public class FuncionarioMinDTO {

    private Long id;
    private String nome;
    private String emailWorkspace;
    private Setor setor;

    public FuncionarioMinDTO() {

    }

    public FuncionarioMinDTO(Funcionario entity) {
        id = entity.getId();
        nome = entity.getNome();
        emailWorkspace = entity.getEmailWorkspace();
        setor = entity.getSetor();
    }

    public FuncionarioMinDTO(FuncionarioMinProjection projection) {
        id = projection.getId();
        nome = projection.getNome();
        emailWorkspace = projection.getEmailWorkspace();
        setor = projection.getSetor();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmailWorkspace() {
        return emailWorkspace;
    }

    public Setor getSetor() {
        return setor;
    }
}

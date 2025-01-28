package com.gustavo.gestao_api_rest.dto;

import com.gustavo.gestao_api_rest.entities.Funcionario;

public class FuncionarioDTO {

    private Long id;
    private String nome;
    private String emailWorkspace;
    private String setor;

    public FuncionarioDTO() {

    }

    public FuncionarioDTO(Funcionario entity) {
        id = entity.getId();
        nome = entity.getNome();
        emailWorkspace = entity.getEmailWorkspace();
        setor = entity.getSetor() != null ? entity.getSetor().getNome() : null; // verifica se o funcionário tem um setor associado, se não tiver retorna nulo
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

    public String getSetor() {
        return setor;
    }
}

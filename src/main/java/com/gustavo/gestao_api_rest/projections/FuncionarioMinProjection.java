package com.gustavo.gestao_api_rest.projections;

import com.gustavo.gestao_api_rest.entities.Setor;

public interface FuncionarioMinProjection {

    Long getId();
    String getNome();
    String getEmailWorkspace();
    Setor getSetor();
}

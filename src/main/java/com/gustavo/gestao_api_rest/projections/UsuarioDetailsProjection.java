package com.gustavo.gestao_api_rest.projections;

public interface UsuarioDetailsProjection {

    String getUsername();
    String getSenha();
    Long getRoleId();
    String getAuthority();
}

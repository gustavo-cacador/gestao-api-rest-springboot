package com.gustavo.gestao_api_rest.services;

import com.gustavo.gestao_api_rest.entities.Usuario;
import com.gustavo.gestao_api_rest.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioService usuarioService;

    public void validateSelfOrAdmin(long userId) {
        Usuario me = usuarioService.authenticated();
        if (!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)) {
            throw new ForbiddenException("Acesso negado");
        }
    }
}

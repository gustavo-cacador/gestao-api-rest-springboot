package com.gustavo.gestao_api_rest.controllers;

import com.gustavo.gestao_api_rest.dto.UsuarioDTO;
import com.gustavo.gestao_api_rest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @GetMapping(value = "/{me}")
    public ResponseEntity<UsuarioDTO> getMe() {
        UsuarioDTO dto = usuarioService.getMe();
        return ResponseEntity.ok(dto);
    }
}

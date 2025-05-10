package com.gustavo.gestao_api_rest.controllers;

import com.gustavo.gestao_api_rest.dto.SetorDTO;
import com.gustavo.gestao_api_rest.services.SetorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/setores")
public class SetorController {

    @Autowired
    private SetorService setorService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<SetorDTO> procurarPorId(@PathVariable Long id) {
        SetorDTO dto = setorService.procurarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<SetorDTO> buscarTodos() {
        return setorService.buscarTodos();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<SetorDTO> inserirSetor(@Valid @RequestBody SetorDTO dto) {
        dto = setorService.inserirSetor(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<SetorDTO> atualizarSetor(@PathVariable Long id, @Valid @RequestBody SetorDTO dto) {
        dto = setorService.atualizarSetor(id, dto);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarSetor(@PathVariable Long id) {
        setorService.deletarSetor(id);
        return ResponseEntity.noContent().build();
    }
}

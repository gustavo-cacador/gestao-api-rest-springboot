package com.gustavo.gestao_api_rest.controllers;

import com.gustavo.gestao_api_rest.dto.DemandaDTO;
import com.gustavo.gestao_api_rest.services.DemandaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/demandas")
public class DemandaController {

    @Autowired
    private DemandaService demandaService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<DemandaDTO> procurarPorId(@PathVariable Long id) {
        DemandaDTO dto = demandaService.procurarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @GetMapping
    public List<DemandaDTO> buscarTodos() {
        return demandaService.buscarTodos();
    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @PostMapping
    public ResponseEntity<DemandaDTO> inserirDemanda(@Valid @RequestBody DemandaDTO dto) {
        dto = demandaService.inserirDemanda(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<DemandaDTO> atualizarDemanda(@PathVariable Long id, @Valid @RequestBody DemandaDTO dto) {
        dto = demandaService.atualizarDemanda(id, dto);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarDemanda(@PathVariable Long id) {
        demandaService.deletarDemanda(id);
        return ResponseEntity.noContent().build();
    }
}

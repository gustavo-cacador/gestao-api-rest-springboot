package com.gustavo.gestao_api_rest.controllers;

import com.gustavo.gestao_api_rest.dto.EquipamentoDTO;
import com.gustavo.gestao_api_rest.dto.EquipamentoMinDTO;
import com.gustavo.gestao_api_rest.services.EquipamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<EquipamentoDTO> procurarPorId(@PathVariable Long id) {
        EquipamentoDTO dto = equipamentoService.procurarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/buscar")
    public ResponseEntity<List<EquipamentoMinDTO>> searchByName(@RequestParam(name = "tipo", defaultValue = "") String tipo) {
        List<EquipamentoMinDTO> list = equipamentoService.searchByName(tipo);
        return ResponseEntity.ok(list);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<EquipamentoDTO> buscarTodos() {
        return equipamentoService.buscarTodos();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<EquipamentoDTO> inserirEquipamento(@Valid @RequestBody EquipamentoDTO dto) {
        dto = equipamentoService.inserirEquipamento(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<EquipamentoDTO> atualizarEquipamento(@PathVariable Long id, @Valid @RequestBody EquipamentoDTO dto) {
        dto = equipamentoService.atualizarEquipamento(id, dto);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarEquipamento(@PathVariable Long id) {
        equipamentoService.deletarEquipamento(id);
        return ResponseEntity.noContent().build();
    }
}

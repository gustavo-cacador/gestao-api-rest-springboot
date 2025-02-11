package com.gustavo.gestao_api_rest.controllers;

import com.gustavo.gestao_api_rest.dto.SetorDTO;
import com.gustavo.gestao_api_rest.services.SetorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/setores")
public class SetorController {

    @Autowired
    private SetorService setorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<SetorDTO> procurarPorId(@PathVariable Long id) {
        SetorDTO dto = setorService.procurarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public List<SetorDTO> buscarTodos() {
        return setorService.buscarTodos();
    }

    @PostMapping
    public ResponseEntity<SetorDTO> inserirSetor(@Valid @RequestBody SetorDTO dto) {
        dto = setorService.inserirSetor(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SetorDTO> atualizarSetor(@PathVariable Long id, @Valid @RequestBody SetorDTO dto) {
        dto = setorService.atualizarSetor(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarSetor(@PathVariable Long id) {
        setorService.deletarSetor(id);
        return ResponseEntity.noContent().build();
    }
}

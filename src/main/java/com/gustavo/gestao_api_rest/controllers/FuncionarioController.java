package com.gustavo.gestao_api_rest.controllers;

import com.gustavo.gestao_api_rest.dto.FuncionarioDTO;
import com.gustavo.gestao_api_rest.services.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO> procurarPorId(@PathVariable Long id) {
        FuncionarioDTO dto = funcionarioService.procurarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public List<FuncionarioDTO> buscarTodos() {
        return funcionarioService.buscarTodos();
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> inserirFuncionario(@Valid @RequestBody FuncionarioDTO dto) {
        dto = funcionarioService.inserirFuncionario(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO> atualizarFuncionario(@PathVariable Long id, @Valid @RequestBody FuncionarioDTO dto) {
        dto = funcionarioService.atualizarFuncionario(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }


}

package com.gustavo.gestao_api_rest.controllers;

import com.gustavo.gestao_api_rest.dto.FuncionarioDTO;
import com.gustavo.gestao_api_rest.dto.FuncionarioMinDTO;
import com.gustavo.gestao_api_rest.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping(value = "/{id}")
    public FuncionarioDTO buscarPorId(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        FuncionarioDTO result = funcionarioService.buscarPorId(id);
        return result;
    }

    @GetMapping
    public List<FuncionarioMinDTO> buscarTodos() {
        List<FuncionarioMinDTO> result = funcionarioService.buscarTodos();
        return result;
    }
}

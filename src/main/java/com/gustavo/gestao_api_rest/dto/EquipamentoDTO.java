package com.gustavo.gestao_api_rest.dto;

import com.gustavo.gestao_api_rest.entities.Equipamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EquipamentoDTO {

    private Long id;

    @NotNull(message = "O patrimônio é obrigatório.")
    private Integer patrimonio;

    @Size(min = 3, max = 30, message = "Tipo do equipamento precisa ter entre 3 a 30 caracteres.")
    @NotBlank(message = "O tipo do equipamento é obrigatório.")
    private String tipo;

    @Size(min = 3, max = 80, message = "Tipo do equipamento precisa ter entre 3 a 80 caracteres.")
    @NotBlank(message = "O tipo do modelo é obrigatório.")
    private String modelo;

    private String descricao;

    private FuncionarioDTO funcionario;

    private SetorDTO setor;

    public EquipamentoDTO() {
    }

    public EquipamentoDTO(Long id, Integer patrimonio, String tipo, String modelo, String descricao, FuncionarioDTO funcionario, SetorDTO setor) {
        this.id = id;
        this.patrimonio = patrimonio;
        this.tipo = tipo;
        this.modelo = modelo;
        this.descricao = descricao;
        this.funcionario = funcionario;
        this.setor = setor;
    }

    public EquipamentoDTO(Equipamento entity) {
        id = entity.getId();
        patrimonio = entity.getPatrimonio();
        tipo = entity.getTipo();
        modelo = entity.getModelo();
        descricao = entity.getDescricao();
        funcionario = new FuncionarioDTO(entity.getFuncionario());
        setor = new SetorDTO(entity.getSetor());
    }

    public Long getId() {
        return id;
    }

    public Integer getPatrimonio() {
        return patrimonio;
    }

    public String getTipo() {
        return tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public FuncionarioDTO getFuncionario() {
        return funcionario;
    }

    public SetorDTO getSetor() {
        return setor;
    }
}

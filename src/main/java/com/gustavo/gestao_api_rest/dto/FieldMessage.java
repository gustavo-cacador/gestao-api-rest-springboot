package com.gustavo.gestao_api_rest.dto;

public class FieldMessage {

    private String fieldNome;
    private String message;

    public FieldMessage(String fieldNome, String message) {
        this.fieldNome = fieldNome;
        this.message = message;
    }

    public String getFieldNome() {
        return fieldNome;
    }

    public String getMessage() {
        return message;
    }
}

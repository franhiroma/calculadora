package com.prueba.calculadora.dto;

import lombok.Data;

@Data
public class OperacionErr {
    private int code;
    private String message;

    public OperacionErr(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // Getters y setters
}


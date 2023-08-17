package com.prueba.calculadora.dto;

import lombok.Data;

/**
 * Clase que establece la estructura de entrada para realizar una operación en la calculadora.
 */
@Data
public class OperacionIn {
    private double numero1;
    private double numero2;
    private String operacion;
}


package com.prueba.calculadora.service;

import org.springframework.stereotype.Service;

/**
 * Clase que contiene la lógica de servicio para realizar operaciones en la calculadora.
 */
@Service
public class CalculadoraService {
    public double operacion(double numero1, double numero2, String operacion) {
        switch (operacion.toUpperCase()) {
            case "SUMAR":
                return numero1 + numero2;
            case "RESTAR":
                return numero1 - numero2;
            default:
                throw new IllegalArgumentException("Operación inválida");
        }
    }
}

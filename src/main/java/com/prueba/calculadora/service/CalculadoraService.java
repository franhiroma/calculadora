package com.prueba.calculadora.service;

import org.springframework.stereotype.Service;

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

package com.prueba.calculadora.controller;

import com.prueba.calculadora.dto.OperacionIn;
import com.prueba.calculadora.dto.OperacionOut;
import com.prueba.calculadora.service.CalculadoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import io.corp.calculator.TracerImpl;

import java.time.Instant;

/**
 * Clase Controlador para realizar operaciones aritméticas con una API calculadora.
 */
@RequestMapping("/calculadora/v1/")
@RestController
public class CalculadoraControllerV1 {
    @Autowired
    private CalculadoraService calculadoraService;

    @Autowired
    private TracerImpl tracerImpl;

    /**
     * Realiza una operación aritmética (suma o resta exclusivamente) utilizando los números pasados como argumento.
     *
     * @param request La solicitud que contiene los números y el tipo de operación.
     * @return La respuesta que contiene el resultado de la operación.
     */
    @PostMapping("/operacion")
    public ResponseEntity<OperacionOut> calcularOperacion(@RequestBody OperacionIn request) {
        try {
            tracerImpl.trace(Instant.now() + " - Inicio de operación tipo: " + request.getOperacion().toUpperCase());

            double resultado = calculadoraService.operacion(request.getNumero1(), request.getNumero2(),
                    request.getOperacion());

            tracerImpl.trace(Instant.now() + " - Finalización de operación tipo: " + request.getOperacion().toUpperCase());

            OperacionOut response = new OperacionOut();
            response.setResultado(resultado);

            tracerImpl.trace(Instant.now() + " - Resultado de operación: " + response.getResultado());

            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}

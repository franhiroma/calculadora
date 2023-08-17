package com.prueba.calculadora.controller;

import com.prueba.calculadora.dto.OperacionIn;
import com.prueba.calculadora.dto.OperacionOut;
import com.prueba.calculadora.service.CalculadoraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Repeatable;

/**
 * Clase Controlador para realizar operaciones aritméticas con una API calculadora.
 */
@RequestMapping("/calculadora/v1/")
@RestController
public class CalculadoraControllerV1 {
    @Autowired
    private CalculadoraService calculadoraService;

    /**
     * Realiza una operación aritmética (suma o resta exclusivamente) utilizando los números pasados como argumento.
     *
     * @param request La solicitud que contiene los números y el tipo de operación.
     * @return La respuesta que contiene el resultado de la operación.
     */
    @PostMapping("/operacion")
    public ResponseEntity<OperacionOut> calcularOperacion(@RequestBody OperacionIn request) {
        try {

            double resultado = calculadoraService.operacion(request.getNumero1(), request.getNumero2(),
                    request.getOperacion());

            OperacionOut response = new OperacionOut();
            response.setResultado(resultado);

            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}

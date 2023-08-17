package com.prueba.calculadora.controller;

import com.prueba.calculadora.dto.OperacionIn;
import com.prueba.calculadora.dto.OperacionOut;
import com.prueba.calculadora.service.CalculadoraService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


@RequestMapping("/calculadora/v1/")
@RestController
public class CalculadoraControllerV1 {
    @Autowired
    private CalculadoraService calculadoraService;

    @PostMapping("/operacion")
    public OperacionOut calcularOperacion(@RequestBody OperacionIn request) {
        double resultado = calculadoraService.operacion(request.getNumero1(), request.getNumero2(), request.getOperacion());

        OperacionOut response = new OperacionOut();
        response.setResultado(resultado);

        return response;
    }
}

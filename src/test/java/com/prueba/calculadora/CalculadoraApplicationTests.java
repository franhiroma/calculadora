package com.prueba.calculadora;

import com.prueba.calculadora.service.CalculadoraService;
import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CalculadoraApplicationTests {

	@Autowired
	private CalculadoraService calculadoraService;

	@Autowired
	private TracerImpl tracerImpl;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void setUp() {
		calculadoraService = new CalculadoraService();
	}

	@Test
	public void testSumarOK() {
		tracerImpl.trace(Instant.now() + " - testSumarOK()");
		double resultado = calculadoraService.operacion(1.0, 1.0, "Sumar");
		tracerImpl.trace(Instant.now() + " - Resultado: " + resultado);
		tracerImpl.trace(Instant.now() + " - Resultado esperado: " + "2.0");
		assertEquals(2.0, resultado);
	}

	@Test
	public void testRestarOK() {
		tracerImpl.trace(Instant.now() + " - testRestarOK()");
		double resultado = calculadoraService.operacion(5.0, 3.0, "Restar");
		tracerImpl.trace(Instant.now() + " - Resultado: " + resultado);
		tracerImpl.trace(Instant.now() + " - Resultado esperado: " + "2.0");
		assertEquals(2.0, resultado);
	}


	@Test
	public void testOperacionInvalida() {
		tracerImpl.trace(Instant.now() + " - testOperacionInvalida()");
		assertThrows(IllegalArgumentException.class, () ->
				calculadoraService.operacion(5.0, 2.0, "operacion_invalida")
		);
	}

	@Test
	public void testOperacionSinArg() {
		tracerImpl.trace(Instant.now() + " - testOperacionSinArg()");
		assertThrows(NullPointerException.class, () ->
				calculadoraService.operacion(5.0, 2.0, null)
		);
	}



}

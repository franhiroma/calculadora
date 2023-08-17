package com.prueba.calculadora;

import com.prueba.calculadora.service.CalculadoraService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CalculadoraApplicationTests {

	private CalculadoraService calculadoraService;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void setUp() {
		calculadoraService = new CalculadoraService();
	}

	@Test
	public void testSumar() {
		double resultado = calculadoraService.operacion(1.0, 1.0, "Sumar");
		assertEquals(2.0, resultado);
	}

	@Test
	public void testRestar() {
		double resultado = calculadoraService.operacion(5.0, 3.0, "Restar");
		assertEquals(2.0, resultado);
	}

	@Test
	public void testOperacionInvalida() {
		assertThrows(IllegalArgumentException.class, () ->
				calculadoraService.operacion(5.0, 2.0, null)
		);
	}



}

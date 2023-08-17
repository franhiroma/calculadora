package com.prueba.calculadora.config;

import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public TracerImpl tracerImpl() {
        return new TracerImpl();
    }
}

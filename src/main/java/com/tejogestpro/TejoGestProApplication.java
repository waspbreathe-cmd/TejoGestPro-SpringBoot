package com.tejogestpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que inicia el contenedor de Spring Boot y el servidor web embebido
 * para el sistema TejoGest Pro (Canchas de Tejo Don Uriel).
 */
@SpringBootApplication
public class TejoGestProApplication {

    public static void main(String[] args) {
        SpringApplication.run(TejoGestProApplication.class, args);
    }
}
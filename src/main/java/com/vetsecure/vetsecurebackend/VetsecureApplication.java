package com.vetsecure.vetsecurebackend;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VetsecureApplication {

    public static void main(String[] args) {
        // Cargar variables del archivo .env ANTES de iniciar Spring
        try {
            Dotenv dotenv = Dotenv.configure()
                    .filename(".env")
                    .directory("./")
                    .ignoreIfMalformed()
                    .ignoreIfMissing()
                    .load();
            dotenv.entries().forEach(entry -> {
                System.setProperty(entry.getKey(), entry.getValue());
            });

        } catch (Exception e) {
            System.err.println("Error loading .env file");
            // Opcional: lanzar una excepción o manejar el error de otra manera
            // throw new RuntimeException("Failed to load .env file", e);
        }

        SpringApplication.run(VetsecureApplication.class, args);
    }
}

package com.ejemplo.demo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI workshopOpenAPI() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("Workshop Spring Boot API")
                                .description("API REST de ejemplo para Programacion III")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .name("Mario")
                                                .email("mario@demo.com")
                                )
                )
                .externalDocs(
                        new ExternalDocumentation()
                                .description("Documentacion OpenAPI")
                                .url("https://swagger.io/specification/")
                );
    }
}
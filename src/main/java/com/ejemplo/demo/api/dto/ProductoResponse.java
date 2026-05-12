package com.ejemplo.demo.api.dto;

public record ProductoResponse(

        Long id,
        String nombre,
        Double precio,
        Integer stock,
        String categoria

) {
}
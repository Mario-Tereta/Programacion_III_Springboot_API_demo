package com.ejemplo.demo.api.dto;

public record ProductoRequest(

        String nombre,
        Double precio,
        Integer stock,
        Long categoriaId

) {
}
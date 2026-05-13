package com.ejemplo.demo.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.ejemplo.demo.api.dto.ProductoRequest;
import com.ejemplo.demo.api.dto.ProductoResponse;
import com.ejemplo.demo.domain.service.ProductoService;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoResponse crear(
            @RequestBody ProductoRequest request
    ) {

        return productoService.crear(request);
    }

    @GetMapping
    public List<ProductoResponse> listar() {
        return productoService.listar();
    }
    
    @GetMapping("/{id}")
    public ProductoResponse obtenerPorId(
            @PathVariable Long id
    ) {

        return productoService.obtenerPorId(id);
    }
    
    @PutMapping("/{id}")
    public ProductoResponse actualizar(
            @PathVariable Long id,
            @RequestBody ProductoRequest request
    ) {

        return productoService.actualizar(id, request);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(
            @PathVariable Long id
    ) {

        productoService.eliminar(id);
    }
}
package com.ejemplo.demo.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
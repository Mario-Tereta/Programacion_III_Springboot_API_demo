package com.ejemplo.demo.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.ejemplo.demo.api.dto.CategoriaRequest;
import com.ejemplo.demo.api.dto.CategoriaResponse;
import com.ejemplo.demo.domain.service.CategoriaService;


@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaResponse crear(
            @RequestBody CategoriaRequest request
    ) {

        return categoriaService.crear(request);
    }

    @GetMapping
    public List<CategoriaResponse> listar() {
        return categoriaService.listar();
    }
    
    @GetMapping("/{id}")
    public CategoriaResponse obtenerPorId(
            @PathVariable Long id
    ) {

        return categoriaService.obtenerPorId(id);
    }
    
    @PutMapping("/{id}")
    public CategoriaResponse actualizar(
            @PathVariable Long id,
            @RequestBody CategoriaRequest request
    ) {

        return categoriaService.actualizar(id, request);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(
            @PathVariable Long id
    ) {

        categoriaService.eliminar(id);
    }
}
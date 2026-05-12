package com.ejemplo.demo.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejemplo.demo.api.dto.CategoriaRequest;
import com.ejemplo.demo.api.dto.CategoriaResponse;
import com.ejemplo.demo.domain.model.Categoria;
import com.ejemplo.demo.domain.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaResponse crear(CategoriaRequest request) {

        Categoria categoria = new Categoria();

        categoria.setNombre(request.nombre());
        categoria.setDescripcion(request.descripcion());

        Categoria guardada = categoriaRepository.save(categoria);

        return new CategoriaResponse(
                guardada.getId(),
                guardada.getNombre(),
                guardada.getDescripcion()
        );
    }

    public List<CategoriaResponse> listar() {

        return categoriaRepository.findAll()
                .stream()
                .map(c -> new CategoriaResponse(
                        c.getId(),
                        c.getNombre(),
                        c.getDescripcion()
                ))
                .toList();
    }
}
package com.ejemplo.demo.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ejemplo.demo.api.dto.CategoriaRequest;
import com.ejemplo.demo.api.dto.CategoriaResponse;
import com.ejemplo.demo.domain.model.Categoria;
import com.ejemplo.demo.domain.repository.CategoriaRepository;
import com.ejemplo.demo.api.exception.RecursoNoEncontradoException;

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
    
    public CategoriaResponse obtenerPorId(Long id) {

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Categoria no encontrada")
                );

        return new CategoriaResponse(
                categoria.getId(),
                categoria.getNombre(),
                categoria.getDescripcion()
        );
    }
    
    public CategoriaResponse actualizar(Long id, CategoriaRequest request) {

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Categoria no encontrada")
                );

        categoria.setNombre(request.nombre());
        categoria.setDescripcion(request.descripcion());

        Categoria actualizada = categoriaRepository.save(categoria);

        return new CategoriaResponse(
                actualizada.getId(),
                actualizada.getNombre(),
                actualizada.getDescripcion()
        );
    }
    
    public void eliminar(Long id) {

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Categoria no encontrada")
                );

        categoriaRepository.delete(categoria);
    }
}
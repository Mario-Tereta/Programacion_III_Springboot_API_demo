package com.ejemplo.demo.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejemplo.demo.api.dto.ProductoRequest;
import com.ejemplo.demo.api.dto.ProductoResponse;
import com.ejemplo.demo.domain.model.Categoria;
import com.ejemplo.demo.domain.model.Producto;
import com.ejemplo.demo.domain.repository.CategoriaRepository;
import com.ejemplo.demo.domain.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProductoService(
            ProductoRepository productoRepository,
            CategoriaRepository categoriaRepository
    ) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public ProductoResponse crear(ProductoRequest request) {

        Categoria categoria = categoriaRepository.findById(request.categoriaId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria no encontrada")
                );

        Producto producto = new Producto();

        producto.setNombre(request.nombre());
        producto.setPrecio(request.precio());
        producto.setStock(request.stock());
        producto.setCategoria(categoria);

        Producto guardado = productoRepository.save(producto);

        return new ProductoResponse(
                guardado.getId(),
                guardado.getNombre(),
                guardado.getPrecio(),
                guardado.getStock(),
                guardado.getCategoria().getNombre()
        );
    }

    public List<ProductoResponse> listar() {

        return productoRepository.findAll()
                .stream()
                .map(p -> new ProductoResponse(
                        p.getId(),
                        p.getNombre(),
                        p.getPrecio(),
                        p.getStock(),
                        p.getCategoria().getNombre()
                ))
                .toList();
    }
    
    public ProductoResponse obtenerPorId(Long id) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Producto no encontrado")
                );

        return new ProductoResponse(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getCategoria().getNombre()
        );
    }
}
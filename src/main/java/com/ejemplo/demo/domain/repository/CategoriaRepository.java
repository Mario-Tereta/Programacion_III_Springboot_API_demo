package com.ejemplo.demo.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.demo.domain.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
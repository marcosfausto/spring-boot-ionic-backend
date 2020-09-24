package com.marcosfausto.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcosfausto.cursomc.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}

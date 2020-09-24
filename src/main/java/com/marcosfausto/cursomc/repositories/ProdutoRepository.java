package com.marcosfausto.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcosfausto.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}




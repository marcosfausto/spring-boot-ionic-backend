package com.marcosfausto.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.marcosfausto.cursomc.domain.Cidade;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    @Transactional(readOnly=true)
    @Query("SELECT obj FROM Cidade obj WHERE obj.estado.id = :estado_id order by obj.nome")
    List<Cidade> findCidades(@Param("estado_id") Integer estado_id);

}



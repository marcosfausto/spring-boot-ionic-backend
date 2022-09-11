package com.marcosfausto.cursomc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marcosfausto.cursomc.domain.Categoria;
import com.marcosfausto.cursomc.domain.Cidade;
import com.marcosfausto.cursomc.domain.Estado;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EstadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório")
	private String nome;

	public EstadoDTO() {
	}

	public EstadoDTO(Estado obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

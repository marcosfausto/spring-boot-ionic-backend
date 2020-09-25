package com.marcosfausto.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcosfausto.cursomc.domain.Categoria;
import com.marcosfausto.cursomc.domain.Cidade;
import com.marcosfausto.cursomc.domain.Estado;
import com.marcosfausto.cursomc.domain.Produto;
import com.marcosfausto.cursomc.repositories.CategoriaRepository;
import com.marcosfausto.cursomc.repositories.CidadeRepository;
import com.marcosfausto.cursomc.repositories.EstadoRepository;
import com.marcosfausto.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null,"Computador",2000.0);
		Produto p2 = new Produto(null,"Impressora",800.0);
		Produto p3 = new Produto(null,"Mouse",80.0);
		
		Estado est1 = new Estado(null,"São Paulo");
		Estado est2 = new Estado(null,"Minas Gerais");
		
		Cidade c1 = new Cidade(null,"Uberlândia");
		Cidade c2 = new Cidade(null,"São Paulo");
		Cidade c3 = new Cidade(null,"Campinas");

		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().add(cat1);
		
		est1.getCidades().addAll(Arrays.asList(c2,c3));
		est2.getCidades().add(c1);
		
		c1.setEstado(est2);
		c2.setEstado(est1);
		c3.setEstado(est1);

		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
	}

}

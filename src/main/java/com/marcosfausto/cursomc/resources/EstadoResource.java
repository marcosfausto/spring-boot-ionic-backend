package com.marcosfausto.cursomc.resources;

import com.marcosfausto.cursomc.domain.Cidade;
import com.marcosfausto.cursomc.domain.Estado;
import com.marcosfausto.cursomc.dto.CidadeDTO;
import com.marcosfausto.cursomc.dto.EstadoDTO;
import com.marcosfausto.cursomc.services.CidadeService;
import com.marcosfausto.cursomc.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/estados")
public class EstadoResource {
	
	@Autowired
	private EstadoService estadoService;

	@Autowired
	private CidadeService cidadeService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List <EstadoDTO>> findAll(){
		List<Estado> list = estadoService.findAll();
		List<EstadoDTO> listDTO = list.stream().map(EstadoDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value="/{estadoId}/cidades", method=RequestMethod.GET)
	public ResponseEntity<List <CidadeDTO>> findCidadesByEstado(@PathVariable Integer estadoId){
		List<Cidade> list = cidadeService.findByEstado(estadoId);
		List<CidadeDTO> listDTO = list.stream().map(CidadeDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}


}

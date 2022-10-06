package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Categoria;
import com.example.demo.entities.Cidade;
import com.example.demo.entities.Estado;
import com.example.demo.service.CidadeService;

@RestController
@RequestMapping(value="/cidades")
public class CidadeController {
	
	@Autowired
	private CidadeService service;
	
	@GetMapping
	public ResponseEntity<List<Cidade>> findAll(){
		List<Cidade> list = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Cidade> find(@PathVariable Integer id){
		Cidade obj = service.find(id);
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}
	
}

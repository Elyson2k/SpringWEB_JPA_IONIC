package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Estado;
import com.example.demo.service.EstadoService;

@RestController
@RequestMapping(value="/estados")
public class EstadoController {
	
	@Autowired
	private EstadoService service;
	
	@GetMapping
	public ResponseEntity<List<Estado>> findAll(){
		List<Estado> list = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Estado> find(@PathVariable Integer id){
		Estado obj = service.find(id);
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}
}

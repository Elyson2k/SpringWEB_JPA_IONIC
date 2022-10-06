package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Estado;
import com.example.demo.entities.Produto;
import com.example.demo.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repository;
		
	public List<Estado> findAll(){
		List<Estado> list = repository.findAll();
		return list;
	}
	
	public Estado find(Integer id) {
		Optional<Estado> obj = repository.findById(id);
		return obj.get();
	}
	
}

package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Categoria;
import com.example.demo.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> findAll(){
		List<Categoria> list = repository.findAll();
		return list;
	}
	
	public Categoria find(Integer id) {
		if(id==null) {
			throw new ObjectNotFoundException(id, "ID não encontrado!!");
		}
		Optional<Categoria> obj = repository.findById(id);
		return obj.get();
	}
}

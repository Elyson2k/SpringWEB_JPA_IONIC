package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cidade;
import com.example.demo.entities.Estado;
import com.example.demo.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repository;
		
	public List<Cidade> findAll(){
		List<Cidade> list = repository.findAll();
		return list;
	}
	
	public Cidade find(Integer id) {
		Optional<Cidade> obj = repository.findById(id);
		return obj.get();
	}
}

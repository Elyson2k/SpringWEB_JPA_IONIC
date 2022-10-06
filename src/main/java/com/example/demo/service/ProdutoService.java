package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Produto;
import com.example.demo.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
		
	public List<Produto> findAll(){
		List<Produto> list = repository.findAll();
		return list;
	}
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.get();
	}
}

package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll(){
		List<Cliente> list = repository.findAll();
		return list;
	}
	
	public Cliente find(Integer id) {
		if(id==null) {
			throw new ObjectNotFoundException(id, "ID não encontrado!!");
		}
		Optional<Cliente> obj = repository.findById(id);
		return obj.get();
	}
	
}

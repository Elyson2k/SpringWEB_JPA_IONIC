package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Integer>{

}

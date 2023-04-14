package com.example.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}

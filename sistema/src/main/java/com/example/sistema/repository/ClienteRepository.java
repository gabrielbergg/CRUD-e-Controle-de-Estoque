package com.example.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}

package com.example.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}

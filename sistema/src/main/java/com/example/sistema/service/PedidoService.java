package com.example.sistema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.sistema.entities.Pedido;
import com.example.sistema.repository.PedidoRepository;
import com.example.sistema.service.exception.DbException;
import com.example.sistema.service.exception.NotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.orElseThrow(() -> new NotFoundException(id));
	}
	
	public Pedido insert(Pedido obj) {
		return pedidoRepository.save(obj);
	}
	
	public void delete(Long id) {
		
		try {
			findById(id);
			pedidoRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new NotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DbException(e.getMessage()); 
		}
	}
	
	public Pedido update(Long id, Pedido obj) {
		
		try {
			Pedido pedido = pedidoRepository.getReferenceById(id);
			updateData(pedido, obj);
			return pedidoRepository.save(pedido);
		}
		catch(EntityNotFoundException e) {
			throw new NotFoundException(id);
		}
	}

	private void updateData(Pedido pedido, Pedido obj) {
		pedido.setCliente(obj.getCliente());
		pedido.setDataPedido(obj.getDataPedido());
	}
	
	
}

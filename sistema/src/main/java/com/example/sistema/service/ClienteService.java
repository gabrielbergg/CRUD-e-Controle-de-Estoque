package com.example.sistema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.sistema.entities.Cliente;
import com.example.sistema.repository.ClienteRepository;
import com.example.sistema.service.exception.DbException;
import com.example.sistema.service.exception.NotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new NotFoundException(id));
	}
	
	public Cliente insert(Cliente obj) {
		return clienteRepository.save(obj);
	}
	
	public void delete(Long id) {
		
		try {
			findById(id);
			clienteRepository.deleteById(id);
		} 
		catch(EmptyResultDataAccessException e) {
			throw new NotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DbException(e.getMessage()); 
		}
		
	}
	
	public Cliente update(Long id, Cliente obj) {
		
		try {
			Cliente cliente = clienteRepository.getReferenceById(id);
			updateData(cliente, obj);
			return clienteRepository.save(cliente);

		}
		catch(EntityNotFoundException e) {
			throw new NotFoundException(id);
		}
	}

	private void updateData(Cliente cliente, Cliente obj) {
		cliente.setNome(obj.getNome());
		cliente.setTelefone(obj.getTelefone());
		cliente.setEmail(obj.getEmail());
		
	}
	
	
}

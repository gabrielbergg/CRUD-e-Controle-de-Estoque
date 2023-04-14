package com.example.sistema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.sistema.entities.Produto;
import com.example.sistema.repository.ProdutoRepository;
import com.example.sistema.service.exception.DbException;
import com.example.sistema.service.exception.NotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository; 
	
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElseThrow(() -> new NotFoundException(id));
	}
	
	
	public Produto insert(Produto obj) {
		return produtoRepository.save(obj);
	}
	
	
	public void delete(Long id) {
		
		try {
			findById(id);
			produtoRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new NotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DbException(e.getMessage()); 
		}
	}
	
	public Produto update(Long id, Produto obj) {
		
		try {
			Produto produto = produtoRepository.getReferenceById(id);
			updateData(produto, obj);
			return produtoRepository.save(produto);
		}
		catch(EntityNotFoundException e) {
			throw new NotFoundException(id);
		}
	}

	private void updateData(Produto produto, Produto obj) {
		produto.setNome(obj.getNome());
		produto.setPreco(obj.getPreco());
		produto.setQuantidade(obj.getQuantidade());
	}
}

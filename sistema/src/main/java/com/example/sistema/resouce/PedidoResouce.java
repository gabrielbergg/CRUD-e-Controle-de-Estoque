package com.example.sistema.resouce;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.sistema.entities.Pedido;
import com.example.sistema.service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResouce {

	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll() {
		List<Pedido> list = pedidoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id) {
		Pedido obj = pedidoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Pedido> insert(@RequestBody Pedido obj) {
		obj = pedidoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Pedido> delete(@PathVariable Long id) {
		pedidoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Pedido> update(@PathVariable Long id, @RequestBody Pedido obj) {
		obj = pedidoService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
}

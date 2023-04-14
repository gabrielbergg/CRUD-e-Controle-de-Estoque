package com.example.sistema.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.sistema.entities.Cliente;
import com.example.sistema.entities.ItensPedido;
import com.example.sistema.entities.Pedido;
import com.example.sistema.entities.Produto;
import com.example.sistema.repository.ClienteRepository;
import com.example.sistema.repository.ItensPedidoRepository;
import com.example.sistema.repository.PedidoRepository;
import com.example.sistema.repository.ProdutoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItensPedidoRepository itensPedidoRepository;
	
	
	@Override
	public void run(String... args) throws Exception {

		Cliente c1 = new Cliente(null, "Marcos", "(65) 98734-1254", "m1@gmail.com");
		Cliente c2 = new Cliente(null, "Guilherme", "(55) 98092-1214", "Guimelh@gmail.com");
		Cliente c3 = new Cliente(null, "Ana", "(15) 96534-1912", "ana@gmail.com");
		
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Pedido p1 = new Pedido(null, Instant.now(), c1);
		Pedido p2 = new Pedido(null, Instant.now(), c2);
		Pedido p3 = new Pedido(null, Instant.now(), c3);
		
		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Produto pd1 = new Produto(null, "Capinha", 27, 15.0);
		Produto pd2 = new Produto(null, "Fone de ouvido", 20, 55.0);
		Produto pd3 = new Produto(null, "Relógio", 35, 100.0);
		
		produtoRepository.saveAll(Arrays.asList(pd1, pd2, pd3));
		
		
		ItensPedido ip1 = new ItensPedido(pd1, p1, 14, pd1.getPreco());
		ItensPedido ip2 = new ItensPedido(pd2, p2, 15, pd2.getPreco());
		ItensPedido ip3 = new ItensPedido(pd3, p3, 30, pd3.getPreco());
		ItensPedido ip4 = new ItensPedido(pd1, p3, 15, pd1.getPreco());
	
		
		itensPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3, ip4));
		
		
		
		
	}
}

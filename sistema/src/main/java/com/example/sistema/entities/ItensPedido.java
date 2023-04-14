package com.example.sistema.entities;

import java.io.Serializable;
import java.util.Objects;

import com.example.sistema.entities.pk.ItensPedidoPk;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_itensPedido")
public class ItensPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItensPedidoPk id = new ItensPedidoPk();
	
	private Integer quantidadePedido;
	private Double preco;
	
	public ItensPedido() {
	}

	public ItensPedido(Produto produto, Pedido pedido, Integer quantidadePedido, Double preco) {
		id.setProduto(produto);
		id.setPedido(pedido);
		this.quantidadePedido = quantidadePedido;
		this.preco = preco;
	}
	
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	

	public Integer getQuantidadePedido() {
		return quantidadePedido;
	}

	public void setQuantidadePedido(Integer quantidade) {
		this.quantidadePedido = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Double getSubTotal() {
		return getPreco() * getQuantidadePedido();
	}
	

	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItensPedido other = (ItensPedido) obj;
		return Objects.equals(id, other.id);
	}
}

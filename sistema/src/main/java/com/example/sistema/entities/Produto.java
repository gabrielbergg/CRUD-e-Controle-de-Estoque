package com.example.sistema.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer quantidade;
	private Double preco;

	@OneToMany(mappedBy = "id.produto")
	private Set<ItensPedido> itens = new HashSet<>();

	public Produto() {
	}

	public Produto(Long id, String nome, Integer quantidade, Double preco) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getQuantidadeTotal() {
		Integer tot = getQuantidade(), cont = 0;
		String text = "";
		for (ItensPedido ip : itens) {

			if (tot - ip.getQuantidadePedido() >= 0) {
				tot = tot - ip.getQuantidadePedido();
				text = "" + tot;
			} else {
				cont = ip.getQuantidadePedido() - tot;
				text = "Quantidade insuficiente. Você deve adicionar mais " + cont + " unidade(s) de "
						+ ip.getProduto().nome + " no estoque.";
			}
		}
		setQuantidade(tot);
		return text;
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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
}

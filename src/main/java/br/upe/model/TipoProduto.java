package br.upe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
public class TipoProduto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int quantidadeMin;
	
	public TipoProduto() {
		
	}
	
	public TipoProduto(Long id, String nome, int quantidadeMin) {
		this.id = id;
		this.nome = nome;
		this.quantidadeMin = quantidadeMin;
	}
}

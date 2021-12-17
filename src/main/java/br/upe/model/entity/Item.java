package br.upe.model.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Item {
	
	private Produto produto;
	private int quantidade;
	private double valor;
	
	//quando for uma requisicao ao estoque
	public Item(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
}

package br.upe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto implements EntidadeBase{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private TipoProduto tipo;
	private String descricao;
	private int quantidade;
	private double volume;
	private double valor;
	
}

package br.upe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produto implements EntidadeBase{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	@ManyToOne
	@JoinColumn(name = "tipoproduto_id")
	private TipoProduto tipo;
	private String descricao;
	@ManyToOne
	@JoinColumn(name = "movimentacao_id")
	private Movimentacao movimentacao;
	private int quantidade;
	private double volume;
	private double valor;
	@ManyToOne
	@JoinColumn(name = "almoxarifado_id")
	private Almoxarifado almoxarifado;
	
}

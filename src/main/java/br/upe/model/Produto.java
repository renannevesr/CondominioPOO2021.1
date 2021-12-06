package br.upe.model;

import javax.persistence.CascadeType;
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
import lombok.ToString;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Produto{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "tipoproduto_id")
	private TipoProduto tipo;
	private String descricao;
	private int quantidade;
	private double volume;
	private double valor;

}

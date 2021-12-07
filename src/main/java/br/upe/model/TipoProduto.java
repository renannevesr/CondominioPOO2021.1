package br.upe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TipoProduto implements EntidadeBase{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int quantidadeMin;
	/*@OneToMany(mappedBy = "tipo",cascade = CascadeType.ALL)
	private List<Produto> produtos;*/
}

package br.upe.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
public class Movimentacao extends Requisicao implements EntidadeBase{

	private String tipo;
	/*@OneToMany(mappedBy = "movimentacao",cascade = CascadeType.ALL)
	private List<Produto> produtos;*/


}

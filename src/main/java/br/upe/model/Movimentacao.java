package br.upe.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
public class Movimentacao extends Requisicao implements EntidadeBase{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;
	private String tipo;
	@OneToMany(mappedBy = "movimentacao",cascade = CascadeType.ALL)
	private List<Produto> produtos;

	public Movimentacao(Funcionario requerente, double valorTotal, Date data) {
		super(requerente, valorTotal, data);
	}

}

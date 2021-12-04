package br.upe.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Requisicao extends OperacaoSaida{
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;
	

}

package br.upe.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Conta implements EntidadeBase{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String agencia;
	private String numeroConta;
	private String tipo;
	private String banco;
	private double saldo;
	/*@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn(name="conta_id")
	private List<OperacaoEntrada> operacaoEntrada;*/
	/*@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn(name="conta_id")
	private List<Requisicao> requisicao;*/
	/*@OneToMany (mappedBy = "conta")
	private List<OperacaoEntrada> operacaoEntrada;
	@OneToMany 
	private List<Requisicao> requisicao;*/

}

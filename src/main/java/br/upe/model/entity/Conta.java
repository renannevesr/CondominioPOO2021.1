package br.upe.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@Entity
@NoArgsConstructor
@ToString
public class Conta{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String agencia;
	private String numeroConta;
	private String tipo;
	private String banco;
	@Transient
	private double saldo;

	//Operacoes de saida (contabil)
	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="conta_id")
	private List<RequisicaoProdutoCompra> produtoCompra;
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn(name="conta_id")
	private List<RequisicaoServicos> listaServicos;
	
	//Operacoes de Entrada (contabil)
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn(name="conta_id")
	private List<ContaReceber> contaReceber;
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn(name="conta_id")
	private List<Reservas> reservas;
	
	
	public double getSaldo() {
		double valor = 0;
		
		for (Reservas reserva: reservas) {
			valor += reserva.getValor();
		}
		
		for (ContaReceber contareceber: contaReceber) {
			valor += contareceber.getValor();
		}
		
		for(RequisicaoProdutoCompra produtocompra: produtoCompra) {
			valor -= produtocompra.getValorTotal();
		}
		
		for(RequisicaoServicos listaservicos: listaServicos) {
			valor -= listaservicos.getValorTotal();
		}
		
		return valor;
	}
	
	public Conta(Long id, String agencia, String numeroConta, String tipo, String banco, double saldo) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.tipo = tipo;
		this.banco = banco;
		this.saldo = saldo;
	}

}

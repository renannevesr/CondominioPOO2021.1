package br.upe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
public class Conta {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String agencia;
	private String numeroConta;
	private String tipo;
	private String banco;
	private double saldo;
	
	public Conta() {
		
	}
	
	public Conta(Long id, String agencia, String numeroConta, String tipo, String banco, double saldo) {
		this.id = id;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.tipo = tipo;
		this.banco = banco;
		this.saldo = saldo;
	}
		
}

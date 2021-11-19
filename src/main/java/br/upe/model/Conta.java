package br.upe.model;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Conta {

	private String agencia;
	private String numeroConta;
	private String tipo;
	private String banco;
	private double saldo;
	
}

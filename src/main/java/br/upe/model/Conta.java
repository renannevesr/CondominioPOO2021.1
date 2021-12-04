package br.upe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

}

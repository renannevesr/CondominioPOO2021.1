package br.upe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contabil implements EntidadeBase{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double saldoGlobal;

	@OneToMany
	@JoinColumn(name = "contabil_id")
	private List<Conta> contas;
	
}

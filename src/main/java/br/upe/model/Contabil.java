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
@Entity
public class Contabil{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double saldoGlobal;

	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn(name = "contabil_id")
	private List<Conta> contas;
	
}

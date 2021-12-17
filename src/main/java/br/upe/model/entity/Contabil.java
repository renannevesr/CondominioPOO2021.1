package br.upe.model.entity;

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
	@Transient
	private double saldoGlobal;

	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn(name = "contabil_id")
	private List<Conta> contas;
	
	public double getSaldoGlobal() {
		double valor = 0;
		for(Conta conta: contas) {
			valor += conta.getSaldo();
		}
		

		return valor;
	}
	
}

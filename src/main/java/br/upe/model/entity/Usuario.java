package br.upe.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String senha;
	@OneToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	private String user;
	
	public void setUser(Funcionario funcionario) {
		this.user = funcionario.getCpf();
	}
	//Construtor que seta esse user
	
}

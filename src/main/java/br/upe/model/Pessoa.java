package br.upe.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import lombok.Builder;
//import lombok.Data;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter 
@Setter
//@Data
//@Builder
public abstract class Pessoa {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String nome; 
	private String cpf;
	private ArrayList<String> acesso;
	
	
	public Pessoa (Long id, String nome, String cpf, ArrayList<String> acesso) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.acesso = acesso;
	}
}

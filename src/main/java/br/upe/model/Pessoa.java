package br.upe.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//import lombok.Builder;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter 
@Setter
//@Data
//@Builder
public abstract class Pessoa {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String nome; 
	private String cpf;
	//@OneToMany uma pessoa tem varios acessos
	//@OneToOne uma pessoa tem so um acesso
	private ArrayList<String> acesso; //List
	
	
	public Pessoa (Long id, String nome, String cpf, ArrayList<String> acesso) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.acesso = acesso;
	}
}

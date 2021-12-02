package br.upe.model;

import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class Pessoa implements EntidadeBase{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	//@Column(nullable=false)
	private String nome; 
	//@Column(nullable=false)
	private String cpf;
//	@Column(nullable=false)
	private ArrayList<String> acesso; //List
	
	public Pessoa() {
		
	}
	
}

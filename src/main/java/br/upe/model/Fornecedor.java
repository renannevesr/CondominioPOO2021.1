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
public class Fornecedor {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String documentoId;
	
	public Fornecedor() {
		
	}
	
	public Fornecedor(Long id, String nome,String documentoId) {
		this.id = id;
		this.nome = nome;
		this.documentoId = documentoId;
	}

}

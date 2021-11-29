package br.upe.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
@AllArgsConstructor
public class Condominio {
	@Id @GeneratedValue
	private Long id;
	private String nome;
	private String cnpj;
	private String endereco;
	
	public Condominio() {
		
	}
}

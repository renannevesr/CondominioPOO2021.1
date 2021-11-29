package br.upe.model;

import java.util.ArrayList;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
public class Condomino extends Pessoa{
	
	private String contato;
	public Condomino() {
		
	}
	public Condomino(Long id, String nome, String cpf, ArrayList<String> acesso, String contato) {
		super(id, nome, cpf, acesso);
		this.contato = contato;
	}

}

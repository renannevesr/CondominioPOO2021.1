package br.upe.model;

import java.util.ArrayList;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
public class Visitante extends Pessoa{

	private int apartamento;	
	
	public Visitante(Long id, String nome, String cpf, ArrayList<String> acesso, int apartamento) {
		super(id, nome, cpf, acesso);
		this.apartamento = apartamento;
	}
}

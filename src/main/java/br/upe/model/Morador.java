package br.upe.model;

import java.util.ArrayList;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
public class Morador extends Pessoa{

	public Morador(Long id, String nome, String cpf, ArrayList<String> acesso) {
		super(id, nome, cpf, acesso);
	}
}

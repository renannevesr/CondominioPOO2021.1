package br.upe.model;

import java.util.Date;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@Entity
@ToString
public class Funcionario extends Pessoa{
	
	private Date dataAdmissao;
	private String carteiraTrabalho;
	private String funcao;
	
	public Funcionario() {
		
	}
	
}

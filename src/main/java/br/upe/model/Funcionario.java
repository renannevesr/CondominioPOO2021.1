package br.upe.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
public class Funcionario extends Pessoa {
	
	private Date dataAdmissao;
	private String carteiraTrabalho;
	private String funcao;
	
	public Funcionario (Long id, String nome, String cpf, ArrayList<String> acesso, Date dataAdmissao, String carteiraTrabalho, String funcao) {
		super(id, nome, cpf, acesso);
		this.dataAdmissao = dataAdmissao;
		this.carteiraTrabalho = carteiraTrabalho;
		this.funcao = funcao;
	}

}

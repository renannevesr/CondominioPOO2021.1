package br.upe.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter

public class Funcionario extends Pessoa {
	
	private Date dataAdmissao;
	private String carteiraTrabalho;
	private String funcao;

}

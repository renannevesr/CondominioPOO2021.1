package br.upe.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Getter 
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends Pessoa{
	
	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;
	private String carteiraTrabalho;
	@Enumerated(EnumType.STRING)
	private FuncaoFuncionario funcao;
	private String senha;
	
	public Funcionario(Long id, String nome, String cpf, Date dataAdmissao, String carteiraTrabalho, FuncaoFuncionario funcao) {
		super(id, nome, cpf);
		this.dataAdmissao = dataAdmissao;
		this.carteiraTrabalho = carteiraTrabalho;
		this.funcao = funcao;
	}

}

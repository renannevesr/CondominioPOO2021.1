package br.upe.model.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends Pessoa{
	
//	@Temporal(TemporalType.DATE)
	private LocalDate dataAdmissao;
	private String carteiraTrabalho;
	@Enumerated(EnumType.STRING)
	private FuncaoFuncionario funcao;
	private String senha;
	
	public Funcionario(Long id, String nome, String cpf, LocalDate dataAdmissao, String carteiraTrabalho, FuncaoFuncionario funcao, String senha) {
		super(id, nome, cpf);
		this.dataAdmissao = dataAdmissao;
		this.carteiraTrabalho = carteiraTrabalho;
		this.funcao = funcao;
		this.senha = senha;
	}
	
	public Funcionario(Long id, String nome, String cpf, LocalDate dataAdmissao, String carteiraTrabalho, FuncaoFuncionario funcao) {
		super(id, nome, cpf);
		this.dataAdmissao = dataAdmissao;
		this.carteiraTrabalho = carteiraTrabalho;
		this.funcao = funcao;
	}

}

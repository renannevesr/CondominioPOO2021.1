package br.upe.model.entity;

import lombok.*;

import javax.persistence.Entity;
import java.util.Date;

@Getter 
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends Pessoa{
	
	private Date dataAdmissao;
	private String carteiraTrabalho;
	private String funcao;

}

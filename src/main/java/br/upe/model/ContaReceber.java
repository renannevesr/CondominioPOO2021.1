package br.upe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class ContaReceber implements EntidadeBase{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dataEmissao;
	private Date dataVencimento;
	private Date competencia;
	private double valor;
	private String status;
	@ManyToOne 
	private Apartamento responsavel;
	
	
	public ContaReceber() {
		
	}
}

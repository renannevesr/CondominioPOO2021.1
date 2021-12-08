package br.upe.model.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class OperacaoEntrada{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dataEmissao;
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "apartamento_id")
	private Apartamento apartamento;
	private double valor;
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "conta_id")
	private Conta conta;
}

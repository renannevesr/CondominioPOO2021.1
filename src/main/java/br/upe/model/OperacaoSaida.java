package br.upe.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class OperacaoSaida implements EntidadeBase{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double valorTotal;
	private Date data;
}

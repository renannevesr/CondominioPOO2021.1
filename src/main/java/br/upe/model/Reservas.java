package br.upe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservas implements EntidadeBase{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Apartamento responsavel;
	private Espaco local;
	private Date dataSolicitacao;
	private Date dataUtilizacao;
	private double valor;

}

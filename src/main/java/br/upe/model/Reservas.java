package br.upe.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservas extends OperacaoEntrada {

	@ManyToOne
	@JoinColumn(name = "espaco_id")
	private Espaco espaco;
	private Date dataUtilizacao;

}

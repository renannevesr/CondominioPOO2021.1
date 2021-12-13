package br.upe.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
	    name="reservas", 
	    uniqueConstraints=
	        @UniqueConstraint(columnNames={"dataUtilizacao", "espaco_id"})
	)
public class Reservas extends OperacaoEntrada {
	
	@ManyToOne
	@JoinColumn(name = "espaco_id")
	private Espaco espaco;
	@Temporal(TemporalType.DATE)
	private Date dataUtilizacao;

}

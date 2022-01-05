package br.upe.model.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
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
	        @UniqueConstraint(columnNames={"dataUtilizacao", "espaco"})
	)
public class Reservas extends OperacaoEntrada {
	
	@Enumerated (EnumType.STRING)
	private Espacos espaco;
	private LocalDate dataUtilizacao;


}

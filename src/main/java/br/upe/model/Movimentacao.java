package br.upe.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movimentacao extends Requisicao implements EntidadeBase{

	private String tipo;

}

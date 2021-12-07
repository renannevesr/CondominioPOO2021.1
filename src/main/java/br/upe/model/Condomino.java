package br.upe.model;

import javax.persistence.Entity;

import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Condomino extends Pessoa{
	
	private String contato;

}

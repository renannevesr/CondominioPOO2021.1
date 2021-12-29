package br.upe.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum Blocos {
	A ("A"), 
	B ("B"),
	C ("C");
	
	private String bloco;

}

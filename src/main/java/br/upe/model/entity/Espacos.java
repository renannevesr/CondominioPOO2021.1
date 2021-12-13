package br.upe.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Espacos {
	
	ACADEMIA ("Academia"),
	PISCINA("Piscina"),
	SALAODEFESTA_A("Salão de Festas A"),
	SALAODEFESTA_B("Salão de Festas B"),
	CHURRASQUEIRA_A("Churrasqueira A"),
	CHURRASQUEIRA_B("Churrasqueira B");
	private String espacos;
	
	
}

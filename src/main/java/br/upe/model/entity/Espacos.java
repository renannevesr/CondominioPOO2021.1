package br.upe.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Espacos {
	
	ACADEMIA ("Academia"),
	PISCINA("Piscina"),
	SALAO_DE_FESTA_A("Salão de Festas A"),
	SALAO_DE_FESTA_B("Salão de Festas B"),
	CHURRASQUEIRA_A("Churrasqueira A"),
	CHURRASQUEIRA_B("Churrasqueira B");
	private String espacos;
	
	
}

package br.upe.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Servicos {

	JARDINAGEM("Jardinagem"),
	LIMPEZAPISCINA("Limpeza da piscina"),
	MANUTENCAO("Manutenção"),
	PINTURA("Pintura"),
	DESINSETIZAÇÃO("Desinsetização");
	private String servicos;
	
}

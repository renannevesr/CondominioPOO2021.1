package br.upe.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FuncaoFuncionario {

	SINDICO("Sindico"),
	SUBSINDICO("Subsíndico"),
	ALMOXARIFE("Almoxarife"),
	PORTEIRO("Porteiro"),
	ZELADOR("Zelador"),
	ESCRITUARIO("Escrituario");
	private String funcao;
}

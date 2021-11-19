package br.upe.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter

public class Servicos extends Requisicao{

	private ArrayList<Servico> servico;
	private Fornecedor prestador;
}

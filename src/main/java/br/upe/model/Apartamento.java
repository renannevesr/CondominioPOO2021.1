package br.upe.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Apartamento {

	private int numero;
	private Condomino propietario;
	private ArrayList<Morador> moradores;
	private ArrayList<Veiculo> veiculos;
	private double taxaCondominio;
	
}

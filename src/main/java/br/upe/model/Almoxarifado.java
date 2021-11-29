package br.upe.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
public class Almoxarifado {

	private ArrayList<Produto> estoque;
	
}

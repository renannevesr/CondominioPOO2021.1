package br.upe.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
public class Contabil {

	private double saldoGlobal;
	private ArrayList<Conta> contas;
	
}

package br.upe.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Contabil {

	private double saldoGlobal;
	private ArrayList<Conta> contas;
	
}

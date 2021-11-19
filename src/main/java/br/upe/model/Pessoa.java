package br.upe.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Pessoa {
	
	private String nome; 
	private String cpf;
	private ArrayList<String> acesso;
}

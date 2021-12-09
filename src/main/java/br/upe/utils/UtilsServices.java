package br.upe.utils;

import java.util.Date;

public class UtilsServices {
	
	public static void validaCPF(String cpf) throws Exception {
		if(cpf.length() != 11 || !cpf.matches("\\d+")) {
			throw new Exception("CPF invalido!");
		}
	}
	
	public static void validaNome(String nome) throws Exception {
		if(!nome.matches("\\D+")) {
			throw new Exception("Nome invalido!");
		}
	}
	
	public static void dataAntes(Date date) throws Exception{
		
		Date data = new Date();
		
		if(data.before(date)) {
			throw new Exception("Data invalida");
		}
	}
	
public static void dataDepois(Date date) throws Exception{
		
		Date data = new Date();
		
		if(data.after(date)) {
			throw new Exception("Data invalida");
		}
	}
	
}

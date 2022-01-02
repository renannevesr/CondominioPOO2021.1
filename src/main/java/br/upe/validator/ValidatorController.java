package br.upe.validator;

import java.time.LocalDate;

public class ValidatorController {
	
	public static void validaCPF(String cpf) throws Exception {
		if(cpf.length() != 11 || !cpf.matches("\\d+")) {
			throw new Exception("CPF invalido!");
		}
	}
	
	public static void validaCNPJ(String cnpj) throws Exception {
		if(cnpj.length() != 14 || !cnpj.matches("\\d+")) {
			throw new Exception("CNPJ invalido!");
		}
	}
	
	public static void apenasLetras(String texto) throws Exception {
		if(!texto.matches("\\D+")) {
			throw new Exception("Caracteres invalidos!");
		}
	}
	
	public static void apenasNumeros(String texto) throws Exception {
		if(texto.matches("\\D+")) {
			throw new Exception("Caracteres invalidos!");
		}
	}
	
	public static void dataAntes(LocalDate date) throws Exception{

		if(LocalDate.now().isBefore(date)) {
			throw new Exception("Data invalida");
		}
	}
	
public static void dataDepois(LocalDate date) throws Exception{
		
		
		if(LocalDate.now().isAfter(date)) {
			throw new Exception("Data invalida");
		}
	}
	
}

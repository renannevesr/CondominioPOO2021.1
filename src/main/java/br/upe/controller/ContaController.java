package br.upe.controller;

import br.upe.model.dao.ContaDAO.JPAContaDAO;
import br.upe.model.entity.Conta;
import br.upe.validator.ValidatorController;

public class ContaController {

private JPAContaDAO dao = new JPAContaDAO();
	
	public void cadastrar(Conta conta) {
		
		try {		
			ValidatorController.apenasNumeros(conta.getAgencia());
			ValidatorController.apenasNumeros(conta.getNumeroConta());
			dao.salvar(conta);	
		}catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}

	}
}

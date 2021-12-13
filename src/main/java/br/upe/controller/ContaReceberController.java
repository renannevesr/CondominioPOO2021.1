package br.upe.controller;

import br.upe.model.dao.ContaReceberDAO.JPAContaReceberDAO;
import br.upe.model.entity.ContaReceber;
import br.upe.validator.ValidatorController;

public class ContaReceberController {

	private JPAContaReceberDAO dao = new JPAContaReceberDAO();
	
	public void cadastrar (ContaReceber ContaReceber) {
		try {
			ValidatorController.dataDepois(ContaReceber.getDataVencimento());
			dao.salvar(ContaReceber);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}
	
}

package br.upe.controller;

import br.upe.model.dao.ApartamentoDAO.JPAApartamentoDAO;
import br.upe.model.entity.Apartamento;
import br.upe.validator.ValidatorController;

public class ApartamentoController {

	JPAApartamentoDAO dao = new JPAApartamentoDAO();
	
	public void cadastrar (Apartamento apartamento) {
		try {
			ValidatorController.apenasLetras(apartamento.getBloco());
			dao.salvar(apartamento);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}
	
}

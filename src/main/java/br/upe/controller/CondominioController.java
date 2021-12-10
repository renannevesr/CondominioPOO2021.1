package br.upe.controller;

import br.upe.model.dao.CondominioDAO.JPACondominioDAO;
import br.upe.model.entity.Condominio;
import br.upe.validator.ValidatorController;

public class CondominioController {

	private JPACondominioDAO dao = new JPACondominioDAO();
	
	public void cadastrar (Condominio condominio) {
		
		try {
			ValidatorController.validaCNPJ(condominio.getCnpj());
			dao.salvar(condominio);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}

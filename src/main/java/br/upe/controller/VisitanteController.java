package br.upe.controller;

import br.upe.model.dao.VisitanteDAO.JPAVisitanteDAO;
import br.upe.model.entity.Visitante;

public class VisitanteController {

	JPAVisitanteDAO dao = new JPAVisitanteDAO();
	
	public void cadastrar(Visitante visitante) {
		try {
			dao.salvar(visitante);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}
	
}

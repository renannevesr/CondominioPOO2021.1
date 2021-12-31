package br.upe.controller;

import java.util.List;

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
	
	public Visitante atualizar(Visitante visitante) throws Exception{
		return dao.atualizar(visitante);
	}
	
	public List<Visitante> listar() throws Exception {
		return dao.listar();
	}
	
}

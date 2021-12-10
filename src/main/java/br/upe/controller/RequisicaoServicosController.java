package br.upe.controller;

import br.upe.model.dao.RequisicaoServicosDAO.JPARequisicaoServicosDAO;
import br.upe.model.entity.RequisicaoServicos;

public class RequisicaoServicosController {

	private JPARequisicaoServicosDAO dao = new JPARequisicaoServicosDAO();
	
	public void cadastrar(RequisicaoServicos requisicaoServicos) {
		try {
			dao.salvar(requisicaoServicos);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}
	
}

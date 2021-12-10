package br.upe.controller;

import br.upe.model.dao.RequisicaoProdutoDAO.JPARequisicaoProdutoDAO;
import br.upe.model.entity.RequisicaoProduto;

public class RequisicaoProdutoController {

	private JPARequisicaoProdutoDAO dao = new JPARequisicaoProdutoDAO();
	
	public void cadastrar(RequisicaoProduto requisicaoProduto) {
		try {
			dao.salvar(requisicaoProduto);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}
	
}

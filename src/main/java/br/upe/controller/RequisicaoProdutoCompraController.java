package br.upe.controller;

import br.upe.model.dao.RequisicaoProdutoCompraDAO.JPARequisicaoProdutoCompraDAO;
import br.upe.model.entity.RequisicaoProdutoCompra;

public class RequisicaoProdutoCompraController {

	private JPARequisicaoProdutoCompraDAO dao = new JPARequisicaoProdutoCompraDAO();
	
	public void cadastrar(RequisicaoProdutoCompra requisicaoProduto) {
		try {
			dao.salvar(requisicaoProduto);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}
	
}

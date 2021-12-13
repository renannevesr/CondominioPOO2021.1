package br.upe.controller;

import br.upe.model.dao.RequisicaoProdutoEstoqueDAO.JPARequisicaoProdutoEstoqueDAO;
import br.upe.model.entity.RequisicaoProdutoEstoque;

public class RequisicaoProdutoEstoqueController {

	private JPARequisicaoProdutoEstoqueDAO dao = new JPARequisicaoProdutoEstoqueDAO();
	
	public void cadastrar(RequisicaoProdutoEstoque requisicaoProduto) {
		try {
			dao.salvar(requisicaoProduto);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}
	
}

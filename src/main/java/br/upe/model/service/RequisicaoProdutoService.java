package br.upe.model.service;

import br.upe.model.dao.RequisicaoProdutoDAO.JPARequisicaoProdutoDAO;
import br.upe.model.entity.RequisicaoProduto;
import br.upe.utils.UtilsServices;

public class RequisicaoProdutoService {

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

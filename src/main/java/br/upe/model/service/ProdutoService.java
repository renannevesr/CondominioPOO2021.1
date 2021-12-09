package br.upe.model.service;

import br.upe.model.dao.ProdutoDAO.JPAProdutoDAO;
import br.upe.model.entity.Produto;

public class ProdutoService {

	private JPAProdutoDAO dao = new JPAProdutoDAO();
	
	public void cadastrar(Produto propduto) {
		try {
			dao.salvar(propduto);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}
	
}

package br.upe.controller;

import br.upe.model.dao.ProdutoDAO.JPAProdutoDAO;
import br.upe.model.entity.Produto;

public class ProdutoController {

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

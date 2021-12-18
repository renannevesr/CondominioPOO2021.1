package br.upe.controller;

import java.util.List;

import br.upe.model.dao.CondominoDAO.JPACondominoDAO;
import br.upe.model.entity.Condomino;
import br.upe.validator.ValidatorController;

public class CondominoController {
	

	private JPACondominoDAO dao = new JPACondominoDAO();
	
	public void cadastrar(Condomino condomino) {
		
		try {
			ValidatorController.validaCPF(condomino.getCpf());
			ValidatorController.apenasLetras(condomino.getNome());
			ValidatorController.apenasNumeros(condomino.getContato());
			dao.salvar(condomino);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public List<Condomino> listar() throws Exception {
		return dao.listar();
	}
	
}

package br.upe.model.service;

import br.upe.model.dao.CondominoDAO.JPACondominoDAO;
import br.upe.model.entity.Condomino;
import br.upe.utils.UtilsServices;

public class CondominoService {
	

	private JPACondominoDAO dao = new JPACondominoDAO();
	
	public void cadastrar(Condomino condomino) {
		
		try {
			UtilsServices.validaCPF(condomino.getCpf());
			UtilsServices.apenasLetras(condomino.getNome());
			UtilsServices.apenasNumeros(condomino.getContato());
			dao.salvar(condomino);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}

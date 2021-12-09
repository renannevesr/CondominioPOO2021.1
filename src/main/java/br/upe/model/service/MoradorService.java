package br.upe.model.service;

import br.upe.model.dao.MoradorDAO.JPAMoradorDAO;
import br.upe.model.entity.Morador;
import br.upe.utils.UtilsServices;

public class MoradorService {

	private JPAMoradorDAO dao = new JPAMoradorDAO();
	
	public void cadastrar (Morador morador) {
		
		try {			
			UtilsServices.validaCPF(morador.getCpf());
			UtilsServices.apenasLetras(morador.getNome());
			dao.salvar(morador);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		
	}
}

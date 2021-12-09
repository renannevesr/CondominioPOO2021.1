package br.upe.model.service;

import br.upe.model.dao.CondominioDAO.JPACondominioDAO;
import br.upe.model.entity.Condominio;
import br.upe.utils.UtilsServices;

public class CondominioService {

	private JPACondominioDAO dao = new JPACondominioDAO();
	
	public void cadastrar (Condominio condominio) {
		
		try {
			UtilsServices.validaCNPJ(condominio.getCnpj());
			dao.salvar(condominio);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}

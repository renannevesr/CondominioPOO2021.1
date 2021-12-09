package br.upe.model.service;

import br.upe.model.dao.ApartamentoDAO.JPAApartamentoDAO;
import br.upe.model.entity.Apartamento;
import br.upe.utils.UtilsServices;

public class ApartamentoService {

	JPAApartamentoDAO dao = new JPAApartamentoDAO();
	
	public void cadastrar (Apartamento apartamento) {
		try {
			UtilsServices.apenasLetras(apartamento.getBloco());
			dao.salvar(apartamento);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}
	
}

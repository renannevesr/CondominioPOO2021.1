package br.upe.controller;

import java.util.List;

import br.upe.model.dao.ApartamentoDAO.JPAApartamentoDAO;
import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Condomino;
import br.upe.validator.ValidatorController;

public class ApartamentoController {

	JPAApartamentoDAO dao = new JPAApartamentoDAO();
	
	public void cadastrar (Apartamento apartamento) {
		try {
			dao.salvar(apartamento);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public List<Apartamento> listar() throws Exception {
		return dao.listar();
	}
	
}

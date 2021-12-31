package br.upe.controller;

import java.util.List;

import br.upe.model.dao.ApartamentoDAO.JPAApartamentoDAO;
import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Blocos;

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
	
	public void atualizar(Apartamento apartamento) throws Exception {
		dao.atualizar(apartamento);
	}
	
	public List<Apartamento> listar() throws Exception {
		return dao.listar();
	}
	
	public List<Apartamento> buscarApartamento(Blocos bloco, int numero) throws Exception{
		
		return dao.buscarAp(bloco, numero);
	}
	
}

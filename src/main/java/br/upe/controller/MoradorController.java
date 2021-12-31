package br.upe.controller;

import java.util.List;

import br.upe.model.dao.MoradorDAO.JPAMoradorDAO;
import br.upe.model.entity.Morador;
import br.upe.validator.ValidatorController;

public class MoradorController {

	private JPAMoradorDAO dao = new JPAMoradorDAO();
	
	public void cadastrar (Morador morador) {
		
		try {			
			ValidatorController.validaCPF(morador.getCpf());
			ValidatorController.apenasLetras(morador.getNome());
			dao.salvar(morador);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public Morador atualizar(Morador morador) throws Exception{
		return dao.atualizar(morador);
	}
	
	public List<Morador> listar() throws Exception {
		return dao.listar();
	}
}

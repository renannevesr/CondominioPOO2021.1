package br.upe.controller;

import br.upe.model.dao.VeiculoDAO.JPAVeiculoDAO;
import br.upe.model.entity.Veiculo;
import br.upe.validator.ValidatorController;

public class VeiculoController {

	private JPAVeiculoDAO dao = new JPAVeiculoDAO();
	
	public void cadastrar (Veiculo veiculo) {
		try {
			ValidatorController.apenasLetras(veiculo.getCor());
			dao.salvar(veiculo);

		}catch(Exception e) {
			e.getMessage();
		}
	}
	
}

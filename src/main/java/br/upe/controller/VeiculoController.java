package br.upe.controller;

import br.upe.model.dao.VeiculoDAO.JPAVeiculoDAO;
import br.upe.model.entity.Veiculo;

public class VeiculoController {

	private JPAVeiculoDAO dao = new JPAVeiculoDAO();
	
	public void cadastrar (Veiculo veiculo) {
		if(veiculo.getCor().matches("\\d+")) {
			System.out.print("Cor invalida");
		} else {
			dao.salvar(veiculo);
		}
	}
	
}

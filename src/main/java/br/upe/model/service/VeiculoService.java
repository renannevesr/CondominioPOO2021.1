package br.upe.model.service;

import br.upe.model.dao.VeiculoDAO.JPAVeiculoDAO;
import br.upe.model.entity.Veiculo;

public class VeiculoService {

	private JPAVeiculoDAO dao;
	
	public VeiculoService() {
		this.dao = new JPAVeiculoDAO();
	}
	
	public void cadastrar (Veiculo veiculo) {
		if(veiculo.getCor().matches("\\d+")) {
			System.out.print("Cor invalida");
		} else {
			dao.salvar(veiculo);
		}
	}
	
}

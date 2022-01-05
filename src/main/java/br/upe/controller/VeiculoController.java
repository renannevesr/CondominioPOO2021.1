package br.upe.controller;

import java.util.List;

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
	
	public Veiculo atualizar(Veiculo veiculo) throws Exception{
		ValidatorController.apenasLetras(veiculo.getCor());
		return dao.atualizar(veiculo);
	}
	
	public Veiculo buscarPorId(Long id) throws Exception{
		return dao.buscarPorId(id);
	}
	
	public List<Veiculo> listar() throws Exception {
		return dao.listar();
	}
	
	public void remover(Long id) throws Exception{
		dao.remover(id);
	}
	
}

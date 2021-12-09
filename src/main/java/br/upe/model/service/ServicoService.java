package br.upe.model.service;

import br.upe.model.dao.ServicoDAO.JPAServicoDAO;
import br.upe.model.entity.Servico;

public class ServicoService {

	private JPAServicoDAO dao = new JPAServicoDAO();
	
	public void cadastrar (Servico servico) {
		try {
			dao.salvar(servico);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}
	
}

package br.upe.controller;

import br.upe.model.dao.ReservasDAO.JPAReservasDAO;
import br.upe.model.entity.Reservas;
import br.upe.validator.ValidatorController;

public class ReservasController {

	private JPAReservasDAO dao = new JPAReservasDAO();
	
	public void cadastrar (Reservas reservas) {
		try {
			ValidatorController.dataDepois(reservas.getDataUtilizacao());
			dao.salvar(reservas);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}
	
}

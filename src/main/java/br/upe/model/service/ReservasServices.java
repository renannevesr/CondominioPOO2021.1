package br.upe.model.service;

import br.upe.model.dao.ReservasDAO.JPAReservasDAO;
import br.upe.model.entity.Reservas;

public class ReservasServices {

	private JPAReservasDAO dao = new JPAReservasDAO();
	
	public void cadastrar (Reservas reservas) {
		try {
			dao.salvar(reservas);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}
	
}

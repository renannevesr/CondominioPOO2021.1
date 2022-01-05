package br.upe.controller;

import java.util.List;

import br.upe.model.dao.ReservasDAO.JPAReservasDAO;
import br.upe.model.entity.Reservas;
import br.upe.validator.ValidatorController;

public class ReservasController {

	private JPAReservasDAO dao = new JPAReservasDAO();
	
	public void cadastrar (Reservas reservas) throws Exception {
		
		System.out.println("Chegou no controller: " + reservas);
		try {
			ValidatorController.dataDepois(reservas.getDataUtilizacao());
			dao.salvar(reservas);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}
	
	public Reservas atualizar(Reservas reserva) throws Exception{
		ValidatorController.dataDepois(reserva.getDataUtilizacao());
		return dao.atualizar(reserva);
	}
	
	public List<Reservas> listar() throws Exception {
		return dao.listar();
	}
	
	
	public Reservas buscarPorId(Long id) throws Exception{
		return dao.buscarPorId(id);
	}
		
	public void remover (Long id) throws Exception{
		dao.remover(id);
	}
	
}

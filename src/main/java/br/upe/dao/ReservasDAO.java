package br.upe.dao;

import br.upe.model.Reservas;

public interface ReservasDAO {

	public class JPAReservasDAO extends GenericDAO<Reservas, Long>{
		
		public JPAReservasDAO() {
		       super(Reservas.class);
		    } 
	}
}

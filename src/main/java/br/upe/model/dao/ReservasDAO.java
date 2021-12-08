package br.upe.model.dao;

import br.upe.model.entity.Reservas;

public interface ReservasDAO {

	public class JPAReservasDAO extends GenericDAO<Reservas, Long>{
		
		public JPAReservasDAO() {
		       super(Reservas.class);
		    } 
	}
}

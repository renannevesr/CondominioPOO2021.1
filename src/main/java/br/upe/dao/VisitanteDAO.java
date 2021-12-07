package br.upe.dao;

import br.upe.model.Visitante;

public interface VisitanteDAO {

	public class JPAVisitanteDAO extends GenericDAO<Visitante, Long>{
		
		public JPAVisitanteDAO() {
		       super(Visitante.class);
		    }  
	}
}

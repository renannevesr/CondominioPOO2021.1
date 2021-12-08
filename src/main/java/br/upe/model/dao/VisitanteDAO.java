package br.upe.model.dao;

import br.upe.model.entity.Visitante;

public interface VisitanteDAO {

	public class JPAVisitanteDAO extends GenericDAO<Visitante, Long>{
		
		public JPAVisitanteDAO() {
		       super(Visitante.class);
		    }  
	}
}

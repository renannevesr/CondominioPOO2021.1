package br.upe.model.dao;

import br.upe.model.entity.Condomino;


public interface CondominoDAO {
	
	
	public class JPACondominoDAO extends GenericDAO<Condomino, Long>{
		
		public JPACondominoDAO() {
		       super(Condomino.class);
		    }   
	}
	
}

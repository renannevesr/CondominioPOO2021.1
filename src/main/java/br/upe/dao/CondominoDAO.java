package br.upe.dao;

import br.upe.model.Condomino;


public interface CondominoDAO {
	
	
	public class JPACondominoDAO extends GenericDAO<Condomino, Long>{
		
		public JPACondominoDAO() {
		       super(Condomino.class);
		    }   
	}
	
}

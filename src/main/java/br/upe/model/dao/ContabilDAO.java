package br.upe.model.dao;

import br.upe.model.entity.Contabil;

public interface ContabilDAO {
	
	public class JPAContabilDAO extends GenericDAO<Contabil, Long>{
		
		public JPAContabilDAO() {
		       super(Contabil.class);
		    }   
	}

}

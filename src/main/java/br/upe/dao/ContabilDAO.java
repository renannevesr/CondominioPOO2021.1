package br.upe.dao;

import br.upe.model.Contabil;

public interface ContabilDAO {
	
	public class JPAContabilDAO extends GenericDAO<Contabil, Long>{
		
		public JPAContabilDAO() {
		       super(Contabil.class);
		    }   
	}

}

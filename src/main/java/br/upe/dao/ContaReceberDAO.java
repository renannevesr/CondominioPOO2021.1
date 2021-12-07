package br.upe.dao;

import br.upe.model.ContaReceber;

public interface ContaReceberDAO {

	public class JPAContaReceberDAO extends GenericDAO<ContaReceber, Long>{
		
		public JPAContaReceberDAO() {
		       super(ContaReceber.class);
		    }   
	}
}

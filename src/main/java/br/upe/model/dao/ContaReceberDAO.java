package br.upe.model.dao;

import br.upe.model.entity.ContaReceber;

public interface ContaReceberDAO {

	public class JPAContaReceberDAO extends GenericDAO<ContaReceber, Long>{
		
		public JPAContaReceberDAO() {
		       super(ContaReceber.class);
		    }   
	}
}

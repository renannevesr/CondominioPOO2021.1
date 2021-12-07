package br.upe.dao;

import br.upe.model.Apartamento;

public interface ApartamentoDAO {

	
	public class JPAApartamentoDAO extends GenericDAO<Apartamento, Long>{
		
		public JPAApartamentoDAO() {
		       super(Apartamento.class);
		    }   
	}
}

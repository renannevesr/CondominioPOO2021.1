package br.upe.model.dao;

import br.upe.model.entity.Apartamento;

public interface ApartamentoDAO {

	
	public class JPAApartamentoDAO extends GenericDAO<Apartamento, Long>{
		
		public JPAApartamentoDAO() {
		       super(Apartamento.class);
		    }   
	}
}

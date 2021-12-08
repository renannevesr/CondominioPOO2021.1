package br.upe.model.dao;

import br.upe.model.entity.Morador;

public interface MoradorDAO {

	
public class JPAMoradorDAO extends GenericDAO<Morador, Long>{
	
	public JPAMoradorDAO() {
	       super(Morador.class);
	    }   
	
	}
	
}



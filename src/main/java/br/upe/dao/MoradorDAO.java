package br.upe.dao;

import br.upe.model.Morador;

public interface MoradorDAO {

	
public class JPAMoradorDAO extends GenericDAO<Morador, Long>{
	
	public JPAMoradorDAO() {
	       super(Morador.class);
	    }   
	
	}
	
}



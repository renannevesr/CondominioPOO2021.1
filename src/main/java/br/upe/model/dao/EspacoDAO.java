package br.upe.model.dao;

import br.upe.model.entity.Espaco;

public interface EspacoDAO {

	
public class JPAEspacoDAO extends GenericDAO<Espaco, Long> {	
	
	public JPAEspacoDAO() {
	       super(Espaco.class);
	    }   
}

}

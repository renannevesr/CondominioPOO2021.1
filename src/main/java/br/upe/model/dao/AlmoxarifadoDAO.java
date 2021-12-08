package br.upe.model.dao;

import br.upe.model.entity.Almoxarifado;

public interface AlmoxarifadoDAO{

	
public class JPAAlmoxarifadoDAO extends GenericDAO<Almoxarifado, Long>{
		
	public JPAAlmoxarifadoDAO() {
	       super(Almoxarifado.class);
	    }   
}

}

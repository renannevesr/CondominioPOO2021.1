package br.upe.dao;

import br.upe.model.ListaServicos;

public interface ServicosDAO {

	public class JPAServicosDAO extends GenericDAO<ListaServicos, Long>{	
	
		public JPAServicosDAO() {
	       super(ListaServicos.class);
	    }   
	}
}

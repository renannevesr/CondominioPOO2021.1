package br.upe.dao;

import br.upe.model.RequisicaoServicos;

public interface ServicosDAO {

	public class JPAServicosDAO extends GenericDAO<RequisicaoServicos, Long>{	
	
		public JPAServicosDAO() {
	       super(RequisicaoServicos.class);
	    }   
	}
}

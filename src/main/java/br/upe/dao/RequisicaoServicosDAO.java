package br.upe.dao;

import br.upe.model.RequisicaoServicos;

public interface RequisicaoServicosDAO {

	public class JPAServicosDAO extends GenericDAO<RequisicaoServicos, Long>{	
	
		public JPAServicosDAO() {
	       super(RequisicaoServicos.class);
	    }   
	}
}

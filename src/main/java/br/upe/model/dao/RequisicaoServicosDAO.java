package br.upe.model.dao;

import br.upe.model.entity.RequisicaoServicos;

public interface RequisicaoServicosDAO {

	public class JPAServicosDAO extends GenericDAO<RequisicaoServicos, Long>{	
	
		public JPAServicosDAO() {
	       super(RequisicaoServicos.class);
	    }   
	}
}

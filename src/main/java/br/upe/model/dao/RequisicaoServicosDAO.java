package br.upe.model.dao;

import br.upe.model.entity.RequisicaoServicos;

public interface RequisicaoServicosDAO {

	public class JPARequisicaoServicosDAO extends GenericDAO<RequisicaoServicos, Long>{	
	
		public JPARequisicaoServicosDAO() {
	       super(RequisicaoServicos.class);
	    }   
	}
}

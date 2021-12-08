package br.upe.model.dao;

import br.upe.model.entity.Servico;

public interface ServicoDAO {


	public class JPAServicoDAO extends GenericDAO<Servico, Long>{	

		public JPAServicoDAO() {
		       super(Servico.class);
		    }   
	
	}
}

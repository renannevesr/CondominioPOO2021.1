package br.upe.model.dao;

import br.upe.model.entity.Conta;

public interface ContaDAO {
	

public class JPAContaDAO extends GenericDAO<Conta, Long>{	

	public JPAContaDAO() {
	       super(Conta.class);
	    }   

	}
}

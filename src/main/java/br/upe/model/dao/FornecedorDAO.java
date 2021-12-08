package br.upe.model.dao;

import br.upe.model.entity.Fornecedor;

public interface FornecedorDAO {
	
public class JPAFornecedorDAO extends GenericDAO<Fornecedor, Long>{	

	public JPAFornecedorDAO() {
	       super(Fornecedor.class);
	    }   
	
	}

}

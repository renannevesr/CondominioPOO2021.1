package br.upe.dao;

import br.upe.model.Fornecedor;

public interface FornecedorDAO {
	
public class JPAFornecedorDAO extends GenericDAO<Fornecedor, Long>{	

	public JPAFornecedorDAO() {
	       super(Fornecedor.class);
	    }   
	
	}

}

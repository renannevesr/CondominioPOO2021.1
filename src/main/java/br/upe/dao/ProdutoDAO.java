package br.upe.dao;

import br.upe.model.Produto;

public interface ProdutoDAO {

public class JPAProdutoDAO extends GenericDAO<Produto, Long>{
		
		public JPAProdutoDAO() {
		       super(Produto.class);
		    }   
	}
}


package br.upe.model.dao;

import br.upe.model.entity.Produto;

public interface ProdutoDAO {

	public class JPAProdutoDAO extends GenericDAO<Produto, Long>{
		
		public JPAProdutoDAO() {
		       super(Produto.class);
		    }   
	}
}


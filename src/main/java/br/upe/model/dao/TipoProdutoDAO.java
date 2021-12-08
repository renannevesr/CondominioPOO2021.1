package br.upe.model.dao;

import br.upe.model.entity.TipoProduto;

public interface TipoProdutoDAO {


public class JPATipoProdutoDAO extends GenericDAO<TipoProduto, Long>{	

	public JPATipoProdutoDAO() {
	       super(TipoProduto.class);
	    }  
	}
	
}

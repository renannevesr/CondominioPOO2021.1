package br.upe.model.dao;

import br.upe.model.entity.RequisicaoProdutoCompra;

public interface RequisicaoProdutoCompraDAO {
	
	
	public class JPARequisicaoProdutoCompraDAO extends GenericDAO<RequisicaoProdutoCompra, Long>{
		
		public JPARequisicaoProdutoCompraDAO() {
		       super(RequisicaoProdutoCompra.class);
		    }   
	}
}

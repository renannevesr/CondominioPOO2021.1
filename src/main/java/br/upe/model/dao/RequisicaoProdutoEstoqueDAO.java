package br.upe.model.dao;

import br.upe.model.entity.RequisicaoProdutoEstoque;

public interface RequisicaoProdutoEstoqueDAO {
	
	
	public class JPARequisicaoProdutoEstoqueDAO extends GenericDAO<RequisicaoProdutoEstoque, Long>{
		
		public JPARequisicaoProdutoEstoqueDAO() {
		       super(RequisicaoProdutoEstoque.class);
		    }   
	}
}

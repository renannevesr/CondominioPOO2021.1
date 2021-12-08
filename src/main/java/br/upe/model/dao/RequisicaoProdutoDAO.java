package br.upe.model.dao;

import br.upe.model.entity.RequisicaoProduto;

public interface RequisicaoProdutoDAO {
	
	
	public class JPARequisicaoProdutoDAO extends GenericDAO<RequisicaoProduto, Long>{
		
		public JPARequisicaoProdutoDAO() {
		       super(RequisicaoProduto.class);
		    }   
	}
}

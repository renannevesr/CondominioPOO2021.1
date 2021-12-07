package br.upe.dao;

import br.upe.model.RequisicaoProduto;

public interface RequisicaoProdutoDAO {
	
	
	public class JPARequisicaoProdutoDAO extends GenericDAO<RequisicaoProduto, Long>{
		
		public JPARequisicaoProdutoDAO() {
		       super(RequisicaoProduto.class);
		    }   
	}
}

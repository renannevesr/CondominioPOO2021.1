package br.upe.dao;

import br.upe.model.RequisicaoProduto;

public interface MovimentacaoDAO {
	
	
	public class JPAMovimentacaoDAO extends GenericDAO<RequisicaoProduto, Long>{
		
		public JPAMovimentacaoDAO() {
		       super(RequisicaoProduto.class);
		    }   
	}
}

package br.upe.dao;

import java.util.List;

import br.upe.connectionDB.ConnectionDB;
import br.upe.model.TipoProduto;

public interface TipoProdutoDAO {

	void salva(TipoProduto tp);
	List<TipoProduto> lista();

public class JPATipoProdutoDAO implements TipoProdutoDAO{	

	ConnectionDB conexao = new ConnectionDB();

	public void salva (TipoProduto tp) {

		conexao.em.getTransaction().begin();
		conexao.em.persist(tp);
		conexao.em.getTransaction().commit();
		conexao.em.close();
	}

	public List<TipoProduto> lista(){	
		
		List<TipoProduto> tipoProdutos = conexao.em.createQuery("").getResultList();
		conexao.em.close();

		return tipoProdutos;
	}
	}
	
}

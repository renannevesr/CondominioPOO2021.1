package br.upe.dao;

import java.util.List;

import br.upe.connectionDB.ConnectionDB;
import br.upe.model.Fornecedor;

public interface FornecedorDAO {
	
	void salva(Fornecedor F);
	List<Fornecedor> lista();

public class JPAFornecedorDAO implements FornecedorDAO{	

	ConnectionDB conexao = new ConnectionDB();

	public void salva (Fornecedor f) {

		conexao.em.getTransaction().begin();
		conexao.em.persist(f);
		conexao.em.getTransaction().commit();
		conexao.em.close();
	}

	public List<Fornecedor> lista(){	
		
		List<Fornecedor> fornecedores = conexao.em.createQuery("").getResultList();
		conexao.em.close();

		return fornecedores;
	}
	}

}

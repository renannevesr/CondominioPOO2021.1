package br.upe.dao;

import java.util.List;

import br.upe.connectionDB.ConnectionDB;
import br.upe.model.Conta;

public interface ContaDAO {
	void salva(Conta c);
	List<Conta> lista();

public class JPAContaDAO implements ContaDAO{	

	ConnectionDB conexao = new ConnectionDB();

	public void salva (Conta c) {

		conexao.em.getTransaction().begin();
		conexao.em.persist(c);
		conexao.em.getTransaction().commit();
		conexao.em.close();
	}

	public List<Conta> lista(){	
		
		List<Conta> contas = conexao.em.createQuery("").getResultList();
		conexao.em.close();

		return contas;
	}
	}
}

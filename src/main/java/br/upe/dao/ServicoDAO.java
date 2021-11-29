package br.upe.dao;

import java.util.List;

import br.upe.connectionDB.ConnectionDB;
import br.upe.model.Servico;

public interface ServicoDAO {
	void salva(Servico s);
	List<Servico> lista();

	public class JPAServicoDAO implements ServicoDAO{	

	ConnectionDB conexao = new ConnectionDB();

	public void salva (Servico s) {

		conexao.em.getTransaction().begin();
		conexao.em.persist(s);
		conexao.em.getTransaction().commit();
		conexao.em.close();
	}

	public List<Servico> lista(){	
		
		List<Servico> servicos = conexao.em.createQuery("").getResultList();
		conexao.em.close();

		return servicos;
	}
	}
}

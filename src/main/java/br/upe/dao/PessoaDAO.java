package br.upe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upe.connectionDB.ConnectionDB;
import br.upe.model.Pessoa;

public interface PessoaDAO {

	void salva(Pessoa p);
	List<Pessoa> lista();
	
	
public class JPAPessoaDAO implements PessoaDAO{
	
		ConnectionDB conexao = new ConnectionDB();
		
		public void salva (Pessoa p) {
		
			conexao.em.getTransaction().begin();
			conexao.em.persist(p);
			conexao.em.getTransaction().commit();
			conexao.em.close();
		}
		
		public List<Pessoa> lista(){	

			List<Pessoa> pessoas = conexao.em.createQuery("select p from Pessoa p").getResultList();
			conexao.em.close();
			
			return pessoas;
		}
	}
	
}



package br.upe.dao;
import java.util.List;

import br.upe.connectionDB.ConnectionDB;
import br.upe.model.Condominio;
import br.upe.model.Condomino;

public interface CondominioDAO {
	void salva (Condominio c);
	List <Condominio> lista();
	
	public class JPACondominioDAO implements CondominioDAO{
		
		ConnectionDB conexao = new ConnectionDB();
		
		public void salva (Condominio c) {
		
			conexao.em.getTransaction().begin();
			conexao.em.persist(c);
			conexao.em.getTransaction().commit();
			conexao.em.close();
		}

		public List<Condominio> lista(){	
			
			List<Condominio> condominios = conexao.em.createQuery("select c from Condominio c").getResultList();
			conexao.em.close();
			return condominios;
		}
	}
	
}

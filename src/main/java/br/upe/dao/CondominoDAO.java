package br.upe.dao;

import java.util.ArrayList;
import java.util.List;

import br.upe.connectionDB.ConnectionDB;
import br.upe.model.Condomino;


public interface CondominoDAO {
	void salva(Condomino c);
	List<Condomino> lista();
	
	
	public class JPACondominoDAO implements CondominoDAO{
		
		ConnectionDB conexao = new ConnectionDB();
		
		public void salva (Condomino c) {
		
			conexao.em.getTransaction().begin();
			conexao.em.persist(c);
			conexao.em.getTransaction().commit();
			conexao.em.close();
		}
		
		public List<Condomino> lista(){	
			
			List<Condomino> condominos = conexao.em.createQuery("select c from Condomino c").getResultList();
			conexao.em.close();
			return condominos;
		}
	}
	
}

package br.upe.dao;

import java.util.List;

import br.upe.connectionDB.ConnectionDB;
import br.upe.model.Morador;

public interface MoradorDAO {

	void salva(Morador m);
	List<Morador> lista();
	
	
public class JPAMoradorDAO implements MoradorDAO{
	
		ConnectionDB conexao = new ConnectionDB();
		
		public void salva (Morador m) {
		
			conexao.em.getTransaction().begin();
			conexao.em.persist(m);
			conexao.em.getTransaction().commit();
			conexao.em.close();
		}
		
		public List<Morador> lista(){	
			
			List<Morador> moradores = conexao.em.createQuery("select m from Morador m").getResultList();
			conexao.em.close();
	
			return moradores;
		}
	}
	
}



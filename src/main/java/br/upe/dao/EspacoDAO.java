package br.upe.dao;

import java.util.List;

import br.upe.connectionDB.ConnectionDB;
import br.upe.model.Espaco;

public interface EspacoDAO {

	void salva(Espaco e);
	List<Espaco> lista();
	
public class JPAEspacoDAO implements EspacoDAO{	
	
	ConnectionDB conexao = new ConnectionDB();
	
	public void salva (Espaco e) {
	
		conexao.em.getTransaction().begin();
		conexao.em.persist(e);
		conexao.em.getTransaction().commit();
		conexao.em.close();
	}
	
	public List<Espaco> lista(){	
		
		List<Espaco> espacos = conexao.em.createQuery("SELECT e from Espaco e").getResultList();
		conexao.em.close();
	
		System.out.println(espacos);

		return espacos;
	}
}

}

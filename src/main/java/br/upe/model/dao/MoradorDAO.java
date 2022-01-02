package br.upe.model.dao;

import java.util.List;

import br.upe.connectionDB.ConnectionDB;
import br.upe.model.entity.Morador;

public interface MoradorDAO {

	
public class JPAMoradorDAO extends GenericDAO<Morador, Long>{
	
	public JPAMoradorDAO() {
	       super(Morador.class);
	    }   
	
	public List<Morador> buscarPorAp(Object o, Long apartamento_id) {
		ConnectionDB conexao = new ConnectionDB();
		String query = "Select m from Morador m where m.apartamento=" + apartamento_id;
		
		System.out.println(query);
		
		List<Morador> result = conexao.em.createQuery(query).getResultList();
		conexao.em.close();
		
		return result;
	}

	
}
}



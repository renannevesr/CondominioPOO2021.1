package br.upe.model.dao;

import java.util.List;

import br.upe.connectionDB.ConnectionDB;
import br.upe.model.entity.Visitante;

public interface VisitanteDAO {

	public class JPAVisitanteDAO extends GenericDAO<Visitante, Long>{
		
		public JPAVisitanteDAO() {
		       super(Visitante.class);
		    }  
		
		public List<Visitante> buscarPorAp(Object o, Long apartamento_id) {
			ConnectionDB conexao = new ConnectionDB();
			String query = "Select v from Visitante v where m.apartamento=" + apartamento_id;
			
			System.out.println(query);
			
			List<Visitante> result = conexao.em.createQuery(query).getResultList();
			conexao.em.close();
			
			return result;
		}
	}
}

package br.upe.model.dao;

import br.upe.connectionDB.ConnectionDB;
import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Blocos;

public interface ApartamentoDAO {

	
	public class JPAApartamentoDAO extends GenericDAO<Apartamento, Long>{
		
		public JPAApartamentoDAO() {
		       super(Apartamento.class);
		    }   
		
		public Apartamento buscarAp (Blocos bloco, int numero) {
			ConnectionDB conexao = new ConnectionDB();

			
			String query = "Select a from Apartamento a where a.bloco =:bloco and a.numero=:numero";
			

			return (Apartamento) conexao.em.createQuery(query).setParameter("bloco", bloco).setParameter("numero", numero).getSingleResult();
		}
	}
}

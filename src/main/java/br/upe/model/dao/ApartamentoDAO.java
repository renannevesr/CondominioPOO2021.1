package br.upe.model.dao;

import java.util.List;

import br.upe.connectionDB.ConnectionDB;
import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Blocos;

public interface ApartamentoDAO {

	
	public class JPAApartamentoDAO extends GenericDAO<Apartamento, Long>{
		
		public JPAApartamentoDAO() {
		       super(Apartamento.class);
		    }   
		
		public List<Apartamento> buscarAp (Blocos bloco, int numero) {
			ConnectionDB conexao = new ConnectionDB();
			String query = "Select a from Apartamento a";

			List<Apartamento> result = null;
			
			if(bloco == Blocos.Todos) {
				bloco = null;
			}

			if(bloco != null && numero != 0 ){
				String filter = " where a.bloco =:bloco and a.numero=:numero";
				query = query.concat(filter);
				result = (List<Apartamento>) conexao.em.createQuery(query).setParameter("bloco", bloco).setParameter("numero", numero).getResultList();
			}else if (bloco == null && numero !=0) {
				String filter = " where a.numero=:numero";
				query = query.concat(filter);
				result = (List<Apartamento>) conexao.em.createQuery(query).setParameter("numero", numero).getResultList();
			}else if (bloco != null && numero == 0){
				String filter = " where a.bloco=:bloco";
				query = query.concat(filter);
				result = (List<Apartamento>) conexao.em.createQuery(query).setParameter("bloco", bloco).getResultList();
			}else {
				result = (List<Apartamento>) conexao.em.createQuery(query).getResultList();
			}

			return result;
		}

	}
}

package br.upe.model.dao;

import br.upe.connectionDB.ConnectionDB;
import br.upe.model.entity.Veiculo;

public interface VeiculoDAO {

	public Veiculo procurarPlaca(String placa);
	
	public class JPAVeiculoDAO extends GenericDAO<Veiculo, Long> implements VeiculoDAO{
		
		public JPAVeiculoDAO() {
			super(Veiculo.class);
		}
		
		@Override
		public Veiculo procurarPlaca(String placa) {
			
			ConnectionDB conexao = new ConnectionDB();
			String query = "Select v from Veiculo v where v.placa=:placa";
			Veiculo result = (Veiculo) conexao.em.createQuery(query).setParameter("placa", placa).getSingleResult();			
			conexao.em.close();
			
		    return result;
		}
		
	}

}

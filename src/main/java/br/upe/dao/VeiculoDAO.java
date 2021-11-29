package br.upe.dao;

import java.util.List;

import br.upe.connectionDB.ConnectionDB;
import br.upe.model.Veiculo;

public interface VeiculoDAO {

	void salva(Veiculo v);
	List<Veiculo> lista();
	
public class JPAVeiculoDAO implements VeiculoDAO{
		
	ConnectionDB conexao = new ConnectionDB();
	
		public void salva (Veiculo v) {
	
			conexao.em.getTransaction().begin();
			conexao.em.persist(v);
			conexao.em.getTransaction().commit();
			conexao.em.close();
		}
		
		public List<Veiculo> lista(){			

			List<Veiculo> veiculos = conexao.em.createQuery("SELECT v FROM Veiculo v").getResultList();
			conexao.em.close();
	
			for(Veiculo v:veiculos) {
				System.out.println(v.getId() + " | " + v.getPlaca() + " | "+ v.getModelo() + " | " + v.getCor()  + " | ");	
			}
			
			return veiculos;
		}
	}
	
}

package br.upe.dao;

import br.upe.model.Veiculo;

public interface VeiculoDAO {

	
public class JPAVeiculoDAO extends GenericDAO<Veiculo, Long>{
		
	public JPAVeiculoDAO() {
	       super(Veiculo.class);
	    }  
}

}

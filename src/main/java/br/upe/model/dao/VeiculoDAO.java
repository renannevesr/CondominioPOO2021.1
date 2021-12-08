package br.upe.model.dao;

import br.upe.model.entity.Veiculo;

public interface VeiculoDAO {

	
public class JPAVeiculoDAO extends GenericDAO<Veiculo, Long>{
		
	public JPAVeiculoDAO() {
	       super(Veiculo.class);
	    }  
}

}

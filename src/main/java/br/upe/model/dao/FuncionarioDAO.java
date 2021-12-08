package br.upe.model.dao;

import br.upe.model.entity.Funcionario;

public interface FuncionarioDAO {

	public class JPAFuncionarioDAO extends GenericDAO<Funcionario, Long>{	

		public JPAFuncionarioDAO() {
		       super(Funcionario.class);
		    }   
	}
}

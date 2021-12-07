package br.upe.dao;

import br.upe.model.Funcionario;

public interface FuncionarioDAO {

	public class JPAFuncionarioDAO extends GenericDAO<Funcionario, Long>{	

		public JPAFuncionarioDAO() {
		       super(Funcionario.class);
		    }   
	}
}

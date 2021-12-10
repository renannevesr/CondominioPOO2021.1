package br.upe.model.dao;

import br.upe.model.entity.Pessoa;

public interface PessoaDAO {

public class JPAPessoaDAO extends GenericDAO<Pessoa, Long>{
	
	public JPAPessoaDAO() {
	       super(Pessoa.class);
	    }
	}

	public Pessoa buscarCPF (String cpf);

}



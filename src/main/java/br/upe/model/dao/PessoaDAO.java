package br.upe.model.dao;

import br.upe.connectionDB.ConnectionDB;
import br.upe.model.entity.Condomino;
import br.upe.model.entity.Funcionario;
import br.upe.model.entity.Morador;
import br.upe.model.entity.Pessoa;
import br.upe.model.entity.Visitante;

public interface PessoaDAO {
	
	public Pessoa buscarCPF(Object o, String cpf);

public class JPAPessoaDAO extends GenericDAO<Pessoa, Long>{
	
	public JPAPessoaDAO() {
	       super(Pessoa.class);
	    }
	
	public Pessoa buscarCPF(Object o, String cpf) {
		
		ConnectionDB conexao = new ConnectionDB();
		String query ="";
		
		if (o instanceof Funcionario) {
			query = "Select f from Funcionario f where f.cpf=:cpf";
		}
		if (o instanceof Morador) {
			query = "Select m from Morador m where m.cpf=:cpf";
		}
		if (o instanceof Visitante) {
			query = "Select v from Visitante v where v.cpf=:cpf";
		}
		if (o instanceof Condomino) {
			query = "Select c from Condomino c where c.cpf=:cpf";
		}
		
		Pessoa result = (Pessoa) conexao.em.createQuery(query).setParameter("cpf", cpf).getSingleResult();
		conexao.em.close();
	
		return result;
	}
	
	}

}



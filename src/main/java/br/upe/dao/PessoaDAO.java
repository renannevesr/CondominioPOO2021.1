package br.upe.dao;

import java.util.List;

import br.upe.model.Pessoa;

public interface PessoaDAO {

	void salva(Pessoa p);
	List<Pessoa> lista();
	
	
}

public class JDBCPessoaDAO implements PessoaDAO{
	
	public void salva (Pessoa p) {
		
	}
	
	public List<Pessoa> lista(){
		
	}
}

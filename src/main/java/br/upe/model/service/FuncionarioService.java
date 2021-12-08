package br.upe.model.service;

import java.util.Date;

import br.upe.model.dao.FuncionarioDAO.JPAFuncionarioDAO;
import br.upe.model.entity.Funcionario;

public class FuncionarioService {

	private JPAFuncionarioDAO dao;
	
	public void cadastrar(Funcionario funcionario) {
		
		Date data = new Date();
		
		if(funcionario.getCpf().length() != 11) {
			System.out.println("O campo de CPF está incorreto!");
		}else if(data.after(funcionario.getDataAdmissao())){
			System.out.println("A data que você inseriu é maior que a atual.");
		}else{
			dao.salvar(funcionario);
		}
		
	}

 }


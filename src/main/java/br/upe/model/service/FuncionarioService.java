package br.upe.model.service;

import br.upe.model.dao.FuncionarioDAO.JPAFuncionarioDAO;
import br.upe.model.entity.Funcionario;
import br.upe.utils.UtilsServices;

public class FuncionarioService {

	private JPAFuncionarioDAO dao = new JPAFuncionarioDAO();
	
	public void cadastrar(Funcionario funcionario) {
		
		try {			
			UtilsServices.validaCPF(funcionario.getCpf());
			UtilsServices.apenasLetras(funcionario.getNome());
			UtilsServices.dataAntes(funcionario.getDataAdmissao());
			dao.salvar(funcionario);	
		}catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}

	}

}

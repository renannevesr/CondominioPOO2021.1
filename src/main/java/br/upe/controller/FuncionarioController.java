package br.upe.controller;

import br.upe.model.dao.FuncionarioDAO.JPAFuncionarioDAO;
import br.upe.model.entity.Funcionario;
import br.upe.validator.ValidatorController;

public class FuncionarioController {

	private JPAFuncionarioDAO dao = new JPAFuncionarioDAO();
	
	public void cadastrar(Funcionario funcionario) {
		
		try {			
			ValidatorController.validaCPF(funcionario.getCpf());
			ValidatorController.apenasLetras(funcionario.getNome());
			ValidatorController.dataAntes(funcionario.getDataAdmissao());
			dao.salvar(funcionario);	
		}catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}

	}

}

package br.upe.controller;

import java.util.List;

import br.upe.model.dao.FuncionarioDAO.JPAFuncionarioDAO;
import br.upe.model.dao.PessoaDAO.JPAPessoaDAO;
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
			//e.printStackTrace();
		}
		

	}

	public Funcionario buscaCPF(String cpf) throws Exception {
		JPAPessoaDAO pessoaDAO = new JPAPessoaDAO();
		return (Funcionario) pessoaDAO.buscarCPF(new Funcionario(), cpf);
	}
	
	public List<Funcionario> listar() throws Exception {
		return dao.listar();
	}
	
	public Funcionario atualizar(Funcionario Funcionario) throws Exception{
		return dao.atualizar(Funcionario);
	}
	
	public void remover(Funcionario Funcionario) throws Exception{
		dao.remover(Funcionario.getId());
	}
}

package br.upe.controller;

import java.util.List;

import br.upe.model.dao.MoradorDAO.JPAMoradorDAO;
import br.upe.model.dao.PessoaDAO.JPAPessoaDAO;
import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Morador;
import br.upe.model.entity.Pessoa;
import br.upe.validator.ValidatorController;

public class MoradorController {

	private JPAMoradorDAO dao = new JPAMoradorDAO();
	JPAPessoaDAO pessoaDAO = new JPAPessoaDAO();
	
	public void cadastrar (Morador morador) {
		
		try {			
			ValidatorController.validaCPF(morador.getCpf());
			ValidatorController.apenasLetras(morador.getNome());
			dao.salvar(morador);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public Morador atualizar(Morador morador) throws Exception{
		ValidatorController.validaCPF(morador.getCpf());
		ValidatorController.apenasLetras(morador.getNome());
		return dao.atualizar(morador);
	}
	
	public List<Morador> listar() throws Exception {
		return dao.listar();
	}
	
	public Morador buscarPorCpf(Morador m, String cpf) {
	
		return (Morador) pessoaDAO.buscarCPF(m, cpf);
	}
	
	public Morador buscarPorId(Long id) throws Exception{
		return dao.buscarPorId(id);
	}
		
	public void remover (Long id) throws Exception{
		dao.remover(id);
	}
	
	public List<Morador> buscarPorAp(Apartamento ap) {
		return dao.buscarPorAp(new Morador(), ap.getId());
	}
}

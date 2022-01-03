package br.upe.controller;

import java.util.List;

import br.upe.model.dao.PessoaDAO.JPAPessoaDAO;
import br.upe.model.dao.VisitanteDAO.JPAVisitanteDAO;
import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Visitante;
import br.upe.validator.ValidatorController;

public class VisitanteController {

	private JPAVisitanteDAO dao = new JPAVisitanteDAO();
	private JPAPessoaDAO pessoaDAO = new JPAPessoaDAO();
	
	public void cadastrar(Visitante visitante) {
		try {
			ValidatorController.validaCPF(visitante.getCpf());
			ValidatorController.apenasLetras(visitante.getNome());
			dao.salvar(visitante);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Visitante atualizar(Visitante visitante) throws Exception{
		ValidatorController.validaCPF(visitante.getCpf());
		ValidatorController.apenasLetras(visitante.getNome());
		return dao.atualizar(visitante);
	}
	
	public List<Visitante> listar() throws Exception {
		return dao.listar();
	}
	
	public Visitante buscarPorCpf(Visitante m, String cpf) {
		
		return (Visitante) pessoaDAO.buscarCPF(m, cpf);
	}
	
	public Visitante buscarPorId(Long id) throws Exception{
		return dao.buscarPorId(id);
	}
		
	public void remover (Long id) throws Exception{
		dao.remover(id);
	}
	
	public List<Visitante> buscarPorAp(Apartamento ap) {
		return dao.buscarPorAp(new Visitante(), ap.getId());
	}
	
}

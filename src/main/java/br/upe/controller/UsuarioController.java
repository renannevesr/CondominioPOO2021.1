package br.upe.controller;

import br.upe.model.dao.UsuarioDAO.JPAUsuarioDAO;
import br.upe.model.entity.Usuario;

public class UsuarioController {

	JPAUsuarioDAO dao = new JPAUsuarioDAO();
	
	public void cadastrar(Usuario Usuario) {
		try {
			dao.salvar(Usuario);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}
	
}

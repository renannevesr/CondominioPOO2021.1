package br.upe.model.dao;

import br.upe.model.entity.Usuario;

public interface UsuarioDAO {
	
	
	public class JPAUsuarioDAO extends GenericDAO<Usuario, Long>{
		
		public JPAUsuarioDAO() {
		       super(Usuario.class);
		    }   
	}
	
}

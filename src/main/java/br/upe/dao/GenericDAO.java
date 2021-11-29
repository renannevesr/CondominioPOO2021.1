package br.upe.dao;
import java.util.List;

import br.upe.connectionDB.ConnectionDB;
import br.upe.model.EntidadeBase;

public class GenericDAO<Generic extends EntidadeBase>{
		
		public Generic salvar (Generic g) throws Exception{
			
			ConnectionDB conexao = new ConnectionDB();
			
			try {
				conexao.em.getTransaction().begin();
				if(g.getId() == null) {
					conexao.em.persist(g);
				} else {
					if(!conexao.em.contains(g)) {
						if (conexao.em.find(g.getClass(), g.getId()) == null) {
							throw new Exception ("Erro");
						}
					}
					g = conexao.em.merge(g);
				}
				conexao.em.getTransaction().commit();
			}finally {
				conexao.em.close();
			}
		
			return g;
		}
		
		public List<Generic> listar(Object o){
			
			ConnectionDB conexao = new ConnectionDB();
			List<Generic> listaGenerica = null;
			
			String table = o.getClass().getSimpleName();
			
			listaGenerica = conexao.em.createQuery("select o from " + table + " o").getResultList();
			conexao.em.close();
	
			return listaGenerica;
		}
	}


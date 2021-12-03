package br.upe.dao;
import java.util.List;

import br.upe.connectionDB.ConnectionDB;
import br.upe.model.EntidadeBase;

public class GenericDAO<Generic extends EntidadeBase>{
	
		public Generic salvarOuAtualizar(Generic g) throws Exception{
			
			ConnectionDB conexao = new ConnectionDB();
			
			try {
				conexao.em.getTransaction().begin();
				if(g.getId() == null) {
					conexao.em.persist(g);
				} else {
					g = conexao.em.merge(g);
				}
				conexao.em.getTransaction().commit();
			}catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
				conexao.em.getTransaction().rollback();
			}
			finally {
				conexao.em.close();
			}
		
			return g;
		}
		
		public List<Generic> listar(Generic g){
			
			ConnectionDB conexao = new ConnectionDB();
			List<Generic> listaGenerica = null;
			try {
				
			String table = g.getClass().getSimpleName();
				
			listaGenerica = conexao.em.createQuery("select g from " + table + " g").getResultList();
				
			}catch (Exception e) {
				System.out.println(e);
			}finally {
				conexao.em.close();
			}
		
			return listaGenerica;
		}
		
		public void remover(Class<Generic> o, Long id) {
			
			ConnectionDB conexao = new ConnectionDB();
			
			Generic g = conexao.em.find(o, id);
			try {
				conexao.em.getTransaction().begin();
				conexao.em.remove(g);
				conexao.em.getTransaction().commit();
			}catch(Exception e) {
				System.out.print(e.getMessage());
				conexao.em.getTransaction().rollback();
			}
			finally {
				conexao.em.close();
			}
			
		}
	}


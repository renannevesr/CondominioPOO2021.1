package br.upe.model.dao;
import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.upe.connectionDB.ConnectionDB;

public class GenericDAO<Generic, Id extends Serializable>{
	
	   private Class<Generic> persistedClass;
	   
	   protected GenericDAO() {
	   }

	   protected GenericDAO(Class<Generic> persistedClass) {
	       this();
	       this.persistedClass = persistedClass;
	   }
	   
		public Generic salvar(Generic g){
			
			ConnectionDB conexao = new ConnectionDB();
			
			try {
				conexao.em.getTransaction().begin();
				conexao.em.persist(g);
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
		
		public Generic atualizar(Generic g) throws Exception{
			
			ConnectionDB conexao = new ConnectionDB();
			
			try {
				conexao.em.getTransaction().begin();
				conexao.em.merge(g);
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
		
		public List<Generic> listar() {
			   ConnectionDB conexao = new ConnectionDB();
			   
			   List<Generic> listaGenerica = null;
			   
			   CriteriaBuilder builder = conexao.em.getCriteriaBuilder();
		       CriteriaQuery<Generic> query = builder.createQuery(persistedClass);
		       query.from(persistedClass);
		       
		       listaGenerica = conexao.em.createQuery(query).getResultList();
		       
		       return listaGenerica;
		   }
		
		public Generic buscarPorId(Id id) {
			  ConnectionDB conexao = new ConnectionDB();
		       return conexao.em.find(persistedClass, id);
		 }
		
		public void remover(Id id) {
			
			ConnectionDB conexao = new ConnectionDB();
			
			Generic entity = buscarPorId(id);
			try {
				conexao.em.getTransaction().begin();
				conexao.em.remove(entity);
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


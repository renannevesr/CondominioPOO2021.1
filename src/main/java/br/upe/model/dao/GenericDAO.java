package br.upe.model.dao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.boot.model.relational.Database;
import org.hibernate.exception.ConstraintViolationException;

import br.upe.connectionDB.ConnectionDB;

public class GenericDAO<Generic, Id extends Serializable>{
	
	   private Class<Generic> persistedClass;
	   
	   protected GenericDAO() {
	   }

	   protected GenericDAO(Class<Generic> persistedClass) {
	       this();
	       this.persistedClass = persistedClass;
	   }
	   
		public Generic salvar(Generic g) throws Exception{
			
			ConnectionDB conexao = new ConnectionDB();
			
			try {
				conexao.em.getTransaction().begin();
				conexao.em.persist(g);
				conexao.em.getTransaction().commit();
			}catch(ConstraintViolationException e) {
				System.out.println(e.getMessage());
				throw new Exception("Dados duplicados!");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
				conexao.em.getTransaction().rollback();
				throw e;
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
				conexao.em.flush();
				conexao.em.getTransaction().commit();
			}catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
				conexao.em.getTransaction().rollback();
				throw e;
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
			  
			  Generic result = conexao.em.find(persistedClass, id);
			  conexao.em.close();
			
		      return result;
		 }
		
		public void remover(Id id) {
			
			ConnectionDB conexao = new ConnectionDB();
			
			Generic entity = buscarPorId(id);
			try {
				conexao.em.getTransaction().begin();
				conexao.em.remove(conexao.em.contains(entity) ? entity : conexao.em.merge(entity));
				conexao.em.getTransaction().commit();
			}catch(Exception e) {
				System.out.println("Entrou no exception");
				System.out.print(e.getMessage());
				conexao.em.getTransaction().rollback();
			}
			finally {
				conexao.em.close();
			}
			
		}
		
	}


package br.upe.connectionDB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionDB {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("condominioUPE");
	public EntityManager em = emf.createEntityManager();

	public ConnectionDB() {
		
	}
}

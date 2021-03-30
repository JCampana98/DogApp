package ar.edu.um.disenio.dogsupport.servicioJPA;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAHelper {
	
	private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();
	
	private static final EntityManagerFactory buildEntityManagerFactory(){
		return Persistence.createEntityManagerFactory("persistenceDogSupport");
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
}

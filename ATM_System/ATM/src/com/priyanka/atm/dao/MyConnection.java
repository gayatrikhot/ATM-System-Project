package com.priyanka.atm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyConnection {
	public MyConnection() {
	};

	private static EntityManager entityManager;

	public static EntityManager getEntityManger() {
		if (entityManager == null) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pri");
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
}
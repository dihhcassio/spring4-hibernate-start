 package com.camaleao.starter.server.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public abstract class ServiceBase {

	@PersistenceContext
	protected EntityManager em;
	
	protected Session getSession(){
		return em.unwrap(Session.class);
	}
}

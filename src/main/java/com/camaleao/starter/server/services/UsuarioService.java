package com.camaleao.starter.server.services;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camaleao.starter.server.model.Usuario;

@Service
@Transactional(rollbackFor = Exception.class)
public class UsuarioService extends ServiceBase {


	public Usuario find(int idUsuario) {
		return em.find(Usuario.class, idUsuario);
	}

	public boolean update(Usuario usuario) {
		try {
			em.merge(usuario);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void save(Usuario usuario){
		em.persist(usuario);
		
	}

	public int getCountUsuarios() {
		Query query = getSession().createSQLQuery("select count(*) from usuario");
		return ((Number) query.uniqueResult()).intValue();
	}

}

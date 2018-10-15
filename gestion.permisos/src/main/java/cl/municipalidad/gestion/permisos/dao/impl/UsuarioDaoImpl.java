package cl.municipalidad.gestion.permisos.dao.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.municipalidad.gestion.permisos.dao.UsuarioDao;
import cl.municipalidad.gestion.permisos.dto.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public Serializable save(Usuario u) throws DataAccessException {
		return hibernateTemplate.save(u);
	}
	
	@Transactional
	@Override
	public Usuario getUsuario(Integer id) {
		
		Usuario u = hibernateTemplate.get(Usuario.class, id);
		
		return u;
	}

}

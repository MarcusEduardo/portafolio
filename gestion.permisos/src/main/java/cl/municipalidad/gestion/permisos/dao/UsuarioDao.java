package cl.municipalidad.gestion.permisos.dao;

import java.io.Serializable;

import org.springframework.dao.DataAccessException;

import cl.municipalidad.gestion.permisos.dto.Usuario;

public interface UsuarioDao {
	
	public Serializable save(Usuario u) throws DataAccessException;
	public Usuario getUsuario(Integer id);
	
}

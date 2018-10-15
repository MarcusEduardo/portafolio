package cl.municipalidad.gestion.permisos.dto;

import java.util.Set;

public class TipoEstado {

	private Long id;
	private String descripcion;
	private Set<Permiso> permiso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Permiso> getPermiso() {
		return permiso;
	}

	public void setPermiso(Set<Permiso> permiso) {
		this.permiso = permiso;
	}

}

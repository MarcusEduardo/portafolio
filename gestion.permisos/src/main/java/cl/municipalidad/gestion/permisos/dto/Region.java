package cl.municipalidad.gestion.permisos.dto;

import java.util.Set;

public class Region {

	private Long id;
	private String nombre;
	private Set<Comuna> comunas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Comuna> getComunas() {
		return comunas;
	}

	public void setComunas(Set<Comuna> comunas) {
		this.comunas = comunas;
	}

}

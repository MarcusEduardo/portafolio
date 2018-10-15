package cl.municipalidad.gestion.permisos.dto;

import java.util.Set;

public class TipoEmpleado {

	private Long id;
	private String descripcion;
	private Set<Empleado> empleados;
	private Set<DetalleEmpleado> detalleEmpleados;

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

	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Set<DetalleEmpleado> getDetalleEmpleados() {
		return detalleEmpleados;
	}

	public void setDetalleEmpleados(Set<DetalleEmpleado> detalleEmpleados) {
		this.detalleEmpleados = detalleEmpleados;
	}

}

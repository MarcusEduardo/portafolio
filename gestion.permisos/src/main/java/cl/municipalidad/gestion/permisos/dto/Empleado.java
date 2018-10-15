package cl.municipalidad.gestion.permisos.dto;

import java.util.Set;

public class Empleado {

	private String rut;
	private TipoEmpleado tipo;
	private Comuna comuna;
	private UnidadInterna unidadInterna;
	private String nombreempleado;
	private String apellido;
	private String correo;
	private String direccion;
	private Set<Permiso> permisos;
	private Set<DetalleEmpleado> detalleEmpleados;

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public TipoEmpleado getTipo() {
		return tipo;
	}

	public void setTipo(TipoEmpleado tipo) {
		this.tipo = tipo;
	}

	public Comuna getComuna() {
		return comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}

	public UnidadInterna getUnidadInterna() {
		return unidadInterna;
	}

	public void setUnidadInterna(UnidadInterna unidadInterna) {
		this.unidadInterna = unidadInterna;
	}

	public String getNombreempleado() {
		return nombreempleado;
	}

	public void setNombreempleado(String nombreempleado) {
		this.nombreempleado = nombreempleado;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Set<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(Set<Permiso> permisos) {
		this.permisos = permisos;
	}

	public Set<DetalleEmpleado> getDetalleEmpleados() {
		return detalleEmpleados;
	}

	public void setDetalleEmpleados(Set<DetalleEmpleado> detalleEmpleados) {
		this.detalleEmpleados = detalleEmpleados;
	}

}

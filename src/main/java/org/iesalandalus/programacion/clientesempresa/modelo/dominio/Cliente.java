package org.iesalandalus.programacion.clientesempresa.modelo.dominio;

import java.util.Date;
import java.util.Objects;

public class Cliente {
	private String ER_CORREO;
	private String ER_DNI;
	private String ER_TELEFONO;
	private String ER_FORMATO_FECHA;
	private String nombre;
	private String dni;
	private String correo;
	private String telefono;
	private Date fechaNacimiento;
	
	public Cliente(Cliente cliente) {
		
	}
	public Cliente (String nombre,String dni, String correo,String telefono,Date fechaNacimiento) {
		
	}
	public boolean comprobarLetraDni(String dni) {
		return false;
	}
	public String formateaNombre(String nombre) {
		return nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ER_CORREO, ER_DNI, ER_FORMATO_FECHA, ER_TELEFONO, correo, dni, fechaNacimiento, nombre,
				telefono);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(ER_CORREO, other.ER_CORREO) && Objects.equals(ER_DNI, other.ER_DNI)
				&& Objects.equals(ER_FORMATO_FECHA, other.ER_FORMATO_FECHA)
				&& Objects.equals(ER_TELEFONO, other.ER_TELEFONO) && Objects.equals(correo, other.correo)
				&& Objects.equals(dni, other.dni) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
	}
	

}

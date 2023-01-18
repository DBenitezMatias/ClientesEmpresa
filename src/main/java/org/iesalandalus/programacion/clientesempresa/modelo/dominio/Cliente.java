package org.iesalandalus.programacion.clientesempresa.modelo.dominio;

import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;
public class Cliente {
	private static final String ER_CORREO = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String ER_DNI = "([0-9]{8})([a-zA-Z])";
	private static final String ER_TELEFONO = "(9|6)[0-9]{8}";
	public static final String ER_FORMATO_FECHA = "dd/MM/yyyy";
	private String nombre;
	private String dni;
	private String correo;
	private String telefono;
	private LocalDate fechaNacimiento;
	//constructor copia
	public Cliente(Cliente cliente) {
		if(cliente == null) {
			
			 throw new NullPointerException("ERROR: No es posible copiar un cliente nulo.");
		}
		
		setNombre(cliente.getNombre());
		setDni(cliente.getDni());
		setCorreo(cliente.getCorreo());
		setTelefono(cliente.getTelefono());
		setFechaNacimiento(cliente.getFechaNacimiento());
		
	}
	//constructor con parametros
	public Cliente (String nombre,String dni, String correo,String telefono,LocalDate fechaNacimiento) {
		setNombre(nombre);
		setDni(dni);
		setCorreo(correo);
		setTelefono(telefono);
		setFechaNacimiento(fechaNacimiento); 	
		
	}
	//metodo comprobarLetraDni
	public boolean comprobarLetraDni(String dni) {

		char tempLetraDNI = dni.charAt(dni.length() - 1);
		
		String dniFixed = dni.replaceAll("\\D", "");
		int dniNumber = Integer.parseInt(dniFixed);

		char[] LETRAS_DNI = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V','H', 'L', 'C', 'K', 'E' };
		//segun el resto dividido de 23 podremos verificar las letras que se guardan en el array

		if (LETRAS_DNI[dniNumber % 23] == tempLetraDNI) {
			return true;
		} else
			return false;
	}
	//metodo formatea nombre ,eliminando espacioes en blanco y pasando todo a minuscula y luego los iniciales a mayuscula
	public String formateaNombre(String nombre) {
		Pattern pat = Pattern.compile("[\\w]{1,}", Pattern.UNICODE_CHARACTER_CLASS);
		Matcher mat = pat.matcher(nombre);
		String nombreAFormatear = "";
		while (mat.find()) {
			nombreAFormatear = nombreAFormatear + mat.group().toLowerCase() + " ";
		}
		String[] nombreDividido = nombreAFormatear.split(" ");
		for (int i = 0; i < nombreDividido.length; i++) {
			String inicial = nombreDividido[i].substring(0, 1);
			String restoLetras = nombreDividido[i].substring(1, nombreDividido[i].length());
			inicial = inicial.toUpperCase();
			nombreDividido[i] = inicial + restoLetras;
		}
		nombreAFormatear = "";
		for (int i = 0; i < nombreDividido.length; i++) {
			nombreAFormatear = nombreAFormatear + nombreDividido[i] + " ";
		}
		String nombreFormateado = nombreAFormatear.substring(0, nombreAFormatear.length() - 1);
		return nombreFormateado;
		
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
		if(dni == null) {
			
			 throw new NullPointerException("Error : El dni de un cliente no puede ser nulo.");
		}
		
		if(!dni.matches(ER_DNI)) {
			
			throw new IllegalArgumentException("Error : El dni del cliente no tiene un formato válido.");
		}
		
		if(comprobarLetraDni(dni) == false) {
			
			throw new IllegalArgumentException("Error: La letra del dni del cliente no es correcta.");
		}
		
		
		this.dni = dni;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		
		if(correo == null) {
			
			 throw new NullPointerException("Error : El correo de un cliente no puede ser nulo.");
		}
		
		Pattern pattern = Pattern.compile(ER_CORREO); 
        Matcher mather = pattern.matcher(correo);
        
        if(mather.find() == false) {
        	
        	throw new IllegalArgumentException("Error: El correo no es valido.");
        }
		
		
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {

		if(telefono == null) {
			
			 throw new NullPointerException("Error: El teléfono de un cliente no puede ser nulo.");
		}
		
		if(!telefono.matches(ER_TELEFONO)) {
			
			throw new IllegalArgumentException("Error : El teléfono del cliente no tiene un formato válido.");
		}
		
		
		this.telefono = telefono;
	}
	
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if(fechaNacimiento == null) {
			
			 throw new NullPointerException("Error : La fecha de nacimiento de un cliente no puede ser nula.");
		}
		
		this.fechaNacimiento = fechaNacimiento;
	}
		
	//metodo getIniciales haciendo split del nombre por cada espacio y se guarda en un array las subcadenas
	public String getIniciales() {
		String iniciales ="";
		String[] LetraNombreApellidos = nombre.split("/s");
		for (int i = 0; i < LetraNombreApellidos.length; i++) {
			String primeraLetra =LetraNombreApellidos[i].substring(0,1);
			primeraLetra = primeraLetra.toUpperCase();
			
			LetraNombreApellidos[i] = LetraNombreApellidos[i] = primeraLetra;
		}
		
		for (int i = 0; i < LetraNombreApellidos.length; i++) {
			iniciales = iniciales + LetraNombreApellidos[i];
		}
		return iniciales;
		}
	
	@Override
	public int hashCode() {
		return Objects.hash( correo, dni, fechaNacimiento, nombre,
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
		return Objects.equals(correo, other.correo)
				&& Objects.equals(dni, other.dni) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
	}
	

}

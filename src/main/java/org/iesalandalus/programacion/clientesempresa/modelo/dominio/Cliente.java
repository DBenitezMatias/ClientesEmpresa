package org.iesalandalus.programacion.clientesempresa.modelo.dominio;

import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;
public class Cliente {
	
	
	private static final String ER_CORREO =  "[^@]+@[^@]+\\.[a-zA-Z]{2,}";
	private static final String ER_DNI = "(([0-9]{8})([A-Z|a-z]))";
	static final String ER_TELEFONO = "(9|6)[0-9]{8}";
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
		
		this.nombre = cliente.getNombre();
		this.dni = cliente.getDni();
		this.correo = cliente.getCorreo();
		this.telefono = cliente.getTelefono();
		this.fechaNacimiento = cliente.getFechaNacimiento();
		
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
	public static boolean comprobarLetraDni(String dni) {
	    // Eliminar cualquier espacio en blanco al principio o al final del DNI
	    dni = dni.trim();
	    
	    // El DNI debe tener 9 caracteres
	    if (dni.length() != 9) {
	        return false;
	    }
	    
	    // El primer 8 caracteres deben ser dígitos
	    for (int i = 0; i < 8; i++) {
	        if (!Character.isDigit(dni.charAt(i))) {
	            return false;
	        }
	    }
	    
	    // El último carácter debe ser una letra
	    if (!Character.isLetter(dni.charAt(8))) {
	        return false;
	    }
	    
	    // Convertir la letra a mayúsculas
	    char letter = Character.toUpperCase(dni.charAt(8));
	    
	    // Calcular la letra de control
	    int dniNumber = Integer.parseInt(dni.substring(0, 8));
	    int remainder = dniNumber % 23;
	    char[] letters = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
	    char controlLetter = letters[remainder];
	    
	    // Comparar la letra de control con la letra del DNI
	    if (letter != controlLetter) {
	        return false;
	    }
	    
	    // Si se ha llegado hasta aquí, el DNI es válido
	    return true;
	}

	//metodo formatea nombre ,eliminando espacioes en blanco y pasando todo a minuscula y luego los iniciales a mayuscula
	public static String formateaNombre(String nombre) {
	    nombre = nombre.replaceAll("\\s+"," "); // Eliminar espacios en blanco
	    nombre = nombre.toLowerCase(); // Convertir a minúsculas
	    String[] parts = nombre.split(" ");
	    nombre = "";
	    for (String part : parts) {
	        nombre += part.substring(0,1).toUpperCase() + part.substring(1) + " ";
	    }
	    return nombre.trim();
	}

	
	@Override
	public String toString() {
		return "Cliente [nombre=" + formateaNombre(nombre) + " " +getIniciales(nombre)+ " "+ ", dni=" + dni + ", correo=" + correo + ", telefono=" + telefono
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = formateaNombre(nombre);
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		if(dni == null) {
			
			 throw new NullPointerException("Error : El dni de un cliente no puede ser nulo.");
		}
		
		if(dni.matches(ER_DNI)) {
			
			throw new IllegalArgumentException("Error : El dni del cliente no tiene un formato valido.");
		}
		
		/*else if(comprobarLetraDni(dni) == false) {
			
			throw new IllegalArgumentException("Error: La letra del dni del cliente no es correcta.");}
		
		*/
		
		else  {this.dni = dni;}
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		
		if(correo == null) {
			
			 throw new NullPointerException("Error : El correo de un cliente no puede ser nulo.");
		}
		else if (correo.matches(ER_CORREO)) {
		    throw new IllegalArgumentException("Error: El correo no tiene un formato valido.");
		}else
		
		this.correo = correo;
	}
	public String getTelefono() {
		
		return telefono;
	}
	public void setTelefono(String telefono) {

		if(telefono == null) {
			
			 throw new NullPointerException("Error: El teléfono de un cliente no puede ser nulo.");
		}
		
		else if(telefono.matches(ER_TELEFONO)) {

			throw new IllegalArgumentException("Error : El teléfono del cliente no tiene un formato valido.");
		}else
		
		
		this.telefono = telefono;
	}
	
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public  void setFechaNacimiento(LocalDate fechaNacimiento) {
		if(fechaNacimiento == null) {
			
			 throw new NullPointerException("Error : La fecha de nacimiento de un cliente no puede ser nula.");
		}
		
		
		this.fechaNacimiento = fechaNacimiento;
	}
		
	//metodo getIniciales haciendo split del nombre por cada espacio y se guarda en un array las subcadenas
	public static String getIniciales(String name) {
	    String[] parts = name.split(" ");
	    String initials = "";
	    for (String part : parts) {
	        initials += part.charAt(0);
	    }
	    return initials;
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

package org.iesalandalus.programacion.clientesempresa.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.clientesempresa.modelo.dominio.Cliente;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	public void mostrarMenu() {
		
		System.out.println("ELIGE UNA OPCION");
		System.out.println("--------------------");
		System.out.println("1. BORRAR CLIENTE");
		System.out.println("2. BUSCAR CLIENTE");
		System.out.println("3. INSERTAR CLIENTE");
		System.out.println("4. MOSTRAR CLIENTE");
		System.out.println("5. MOSTRAR FECHA DEL CLIENTE");
		System.out.println("6. SALIR");
		
	}
	public static Opcion elegirOpcion(int opcion) {
		
		opcion=Entrada.entero();
		switch (opcion) {
		case 1: {
			
			return Opcion.BORRAR_CLIENTE;
		}
		case 2:{
			return Opcion.BUSCAR_CLIENTE;
		}  
		case 3:
			return Opcion.INSERTAR_CLIENTE;
		case 4: 
			return Opcion.MOSTRAR_CLIENTES;
		case 5:
			return Opcion.MOSTRAR_CLIENTES_FECHA;
		case 6:
			return Opcion.SALIR;
		default:
			throw new IllegalArgumentException("Unexpected value: " + null);}
		
		}	
	public static Cliente leerCliente() {
		String nombre,correo,telefono;
		LocalDate fechaNacimiento;
		
			System.out.println("Introduce nombre");
			nombre=Entrada.cadena();
			
			System.out.println("Introduce correo");
			correo=Entrada.cadena();
			System.out.println("Introduce telefono");
			telefono=Entrada.cadena();
			
			Consola.leerClienteDni();
			Consola.leerFechaNacimiento();
			
			
		
		return null;
		
		
	}
	
	
	
	public static Cliente leerClienteDni() {
		String dni=null;
		do {System.out.println("Introduce dni");
		dni=Entrada.cadena();
			
		} while (dni.length()<8||1>dni.length());
			System.out.println("Introduce Dni");
			
			
			 
			
		
		return null;
	}
	
	
	
	public static LocalDate leerFechaNacimiento() {
		LocalDate fecha=null;
		do {
			System.out.println("Introduce la fecha en DD/MM/YYYY  ");
			try {
				fecha=LocalDate.parse(Entrada.cadena(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			} catch (IllegalArgumentException e) {
				fecha=null;
				System.out.println("Formato de fecha incorrecto");
			}
		} while (fecha==null);
		return null;
		
	}
	


}

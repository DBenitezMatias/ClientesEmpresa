package org.iesalandalus.programacion.clientesempresa.vista;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.clientesempresa.modelo.dominio.Cliente;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	public static void mostrarMenu() {
		
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
		String nombre, dni, correo = null, telefono;
		LocalDate fechaNacimiento = null;
		Cliente cliente = null;
		boolean fallo;
		do {
			System.out.println("-------------------------");
			
			
			fallo = false;

			System.out.println("Introduce el nombre:");
			nombre = Entrada.cadena();

			System.out.println("Introduce el dni:");
			dni = Entrada.cadena();

			System.out.println("Introduce el correo:");
			correo = Entrada.cadena();

			System.out.println("Introduce el telefono:");
			telefono = Entrada.cadena();
			
			fechaNacimiento = leerFechaNacimiento();

			try {
				cliente = new Cliente(nombre, dni, correo, telefono, fechaNacimiento);

			} catch (NullPointerException | IllegalArgumentException e) {
				System.out.println(e.getMessage());
				fallo = true;
				
				
				
			}
		} while (fallo);
		return cliente;
	}
			

			
			
	public static String leerDni() {
		String dni;
		System.out.println("Introduce dni");
		dni = Entrada.cadena();
		
		return dni;
		
		
	}
	
	public static LocalDate leerFechaNacimiento() {
		
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.print("Ingrese la fecha con el siguiente formato: (DD/MM/YYYY): ");
        String date = Entrada.cadena();
        try {
            return LocalDate.parse(date, dateFormat);
        } catch (Exception e) {
            System.out.println("La fecha ingresada no es valida.");
            return null;
        }
    }

			
		
		
	
			
	


}

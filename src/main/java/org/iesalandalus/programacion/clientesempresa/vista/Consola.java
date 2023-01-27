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
		String nombre,correo,telefono,dni;
		LocalDate fechaNacimiento;
		
			System.out.println("Introduce nombre");
			nombre=Entrada.cadena();
			System.out.println("Introduce correo electronico");
			correo=Entrada.cadena();
			System.out.println("Introduce telefono");
			telefono=Entrada.cadena(); 
			dni=leerDni();			
			fechaNacimiento=leerFechaNacimiento();
			
			Cliente  cliente=new Cliente(nombre,correo,telefono,dni,fechaNacimiento);
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
        
        System.out.print("Ingrese la fecha del cliente (DD/MM/YYYY): ");
        String date = Entrada.cadena();
        try {
            return LocalDate.parse(date, dateFormat);
        } catch (Exception e) {
            System.out.println("La fecha ingresada no es valida.");
            return null;
        }
    }

			
		
		
	
			
	


}

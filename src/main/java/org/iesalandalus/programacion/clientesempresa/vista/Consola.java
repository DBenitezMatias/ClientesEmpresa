package org.iesalandalus.programacion.clientesempresa.vista;

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
	public Opcion elegirOpcion(int opcion) {
		
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
	


}

package org.iesalandalus.programacion.clientesempresa;

import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.clientesempresa.modelo.dominio.Cliente;
import org.iesalandalus.programacion.clientesempresa.modelo.negocio.Clientes;
import org.iesalandalus.programacion.clientesempresa.vista.Consola;
import org.iesalandalus.programacion.clientesempresa.vista.Opcion;

public class MainApp {

	private static final int NUM_MAX_CITAS = 25;
	public static Clientes clientes = new Clientes(NUM_MAX_CITAS);
//metodo main 
	public static void main(String[] args) throws OperationNotSupportedException {
		Opcion opcion;
		do {
			Consola.mostrarMenu();
			opcion = Consola.elegirOpcion(1);
			System.out.println("");
			ejecutarOpcion(opcion);
		} while (opcion != Opcion.SALIR);
		System.out.println("-------------------");
		System.out.println("Saliendo del programa");
	}

	private static void ejecutarOpcion(Opcion opcion) throws OperationNotSupportedException {
		switch (opcion) {
		case INSERTAR_CLIENTE:
			insertarCliente();
			break;
		case BUSCAR_CLIENTE:
			buscarCliente();
			break;
		case BORRAR_CLIENTE:
			borrarCliente();
			break;
		case MOSTRAR_CLIENTES_FECHA:
			mostrarClientesFecha();
			break;
		case MOSTRAR_CLIENTES:
			mostrarClientes();
			break;
		default:
			break;
		}
	}


	private static void insertarCliente() throws OperationNotSupportedException  {
		Cliente cliente = Consola.leerCliente();
		try {
			clientes.insertar(cliente);
		} catch (IllegalArgumentException e) {
			System.out.println();
		}
	}

	
	private static void buscarCliente() {


		try {
			Cliente cliente = Consola.leerCliente();

			if ((clientes.buscar(cliente)) == null) {
				System.out.println("Dicho cliente no esta reservado en el sistema.");
			} else {
				System.out.println(cliente);
			}

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	

	private static void borrarCliente() throws OperationNotSupportedException {
		try {
			Cliente cliente = new Cliente(Consola.leerCliente());
			clientes.borrar(cliente);
			System.out.println("Cliente borrado correctamente.");
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

private static void mostrarClientesFecha() {
		
		try {
			
			LocalDate fechaCliente = Consola.leerFechaNacimiento();

			boolean encontrado = false;
	
			for (int i = 0; i < clientes.getTamano(); i++) {
				if (clientes.get()[i].getFechaNacimiento().equals(fechaCliente)) {
					
					encontrado = true;
					System.out.println(clientes.get()[i].toString());
				}
			}

			if (clientes.getTamano() == 0) {
				System.out.println("El sistema no tiene clientes en su registro.");
			} 
			
			if (encontrado == false) {
				System.out.println("El sistemo no tiene cliente con dada fecha de nacimiento");
			}
			
			
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}



	private static void mostrarClientes() {

		
			Cliente[] clients = clientes.get();
			if (clients.length > 0) {
				for (int i=0; i<clients.length; i++) {
					try {
						System.out.println(clients[i].toString());
					} catch (NullPointerException e) {
						System.out.println("");
					}
					
				}
			} else {
				System.out.println("No hay clientes ");
			}
		


	

}}
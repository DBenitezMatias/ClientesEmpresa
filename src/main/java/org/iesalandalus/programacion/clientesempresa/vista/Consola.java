package org.iesalandalus.programacion.clientesempresa.vista;

public class Consola {
	public Opcion elegirOpcion(int opcion) {
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
			throw new IllegalArgumentException("Unexpected value: " + null);
		}
		
		
	}

}

package org.iesalandalus.programacion.clientesempresa.modelo.negocio;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.clientesempresa.modelo.dominio.Cliente;

public class Clientes {
	// Declaracion de variables capacidad, tamano y un array de clientes
		private int capacidad; 
		private int tamano; 
		private Cliente[] coleccionClientes;
	
	
		// constructor que recibe una capacidad 
		// si la capacidad es menor o igual a 0, lanza una excepcion
		public Clientes(int capacidad) {
			if (capacidad <= 0) { 
				throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
			}
			this.capacidad = capacidad; 
			coleccionClientes = new Cliente[capacidad]; 
		}
		
		
	
	
	
	private boolean tamanoSuperado(int indice) {

		return indice >= tamano;

	}

	private boolean capacidadSuperada(int indice) {

		return indice >= capacidad;

	}
	/*metodo copiaClientes que copia el array de Objetos Cliente y devuelve esa copia con un for y asigna cada elemento a una nueva posición en el array de copia "copiaCliente". Utiliza el método "tamanoSuperado (i)" para determinar si se ha alcanzado el final del array original.
	Cada elemento del nuevo arreglo es una nueva instancia de "Cliente" creada a partir del elemento correspondiente del arreglo original.*/
	private Cliente[] copiaClientes() {

		Cliente[] copiaCliente = new Cliente[capacidad]; 

		for (int i = 0; !tamanoSuperado(i); i++) { 

			copiaCliente[i] = new Cliente(coleccionClientes[i]); 
		}

		return copiaCliente;
	}
	
	// devuelve una copia del array de clientes
	public Cliente[] get() {
		return copiaClientes();
	}
	/*
	 * método llamado "buscarIndice" que busca un objeto "Cliente" en el array y devuelve el índice en el que se encuentra.
	 *  Utiliza un for que itera a través del array "coleccionClientes" y utiliza el método "equals" para comparar cada elemento con el objeto "cliente" pasado como argumento.
	 *   Si se encuentra una coincidencia, se establece una variable "encontrado" como verdadera y se guarda el indice en la variable "indice". Si no se encuentra una coincidencia,
	 *    la variable "indice" se inicia con un valor mas grande que el tamaño array y se devuelve. Utiliza el método "tamanoSuperado(i)" para determinar si se ha alcanzado el final del array.*/
	private int buscarIndice(Cliente cliente) {

		int indice = tamano + 1;
		boolean encontrado = false;
		for (int i = 0; !tamanoSuperado(i) && !encontrado; i++) {

			if (coleccionClientes[i].equals(cliente)) {
				encontrado = true;
				indice = i;
			}
		}
		return indice;
	}
	/*
	 * metodo iinsertar que acepta un objeto "Cliente" como argumento y lo inserta en un array.
	 *  Comienza verificando si el objeto "cliente" es nulo si lo es lanza una excepción "NullPointerException"
	 *  Luego, verifica si el tamaño del arreglo ha superado su capacidad máxima utilizando el método "capacidadSuperada (tamano) si es asi lanza una excepción "OperationNotSupportedException"
	 *  busca el índice del objeto "cliente" en el arreglo utilizando el método "buscarIndice (cliente)" y utiliza el método "tamanoSuperado (indice)"
	 *  para determinar si el objeto ya existe en el array
	 *  Si el objeto no existe, agrega el objeto al arreglo en la posición de tamano y aumenta el valor tamano en uno.
	 *  Si el objeto ya existe en el arreglo, lanza una excepción OperationNotSupportedException */
	public void insertar(Cliente cliente) throws OperationNotSupportedException {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}

		if (capacidadSuperada(tamano)) { 
			throw new OperationNotSupportedException("ERROR: No se aceptan más clientes.");
		}

		int indice = buscarIndice(cliente);

		if (tamanoSuperado(indice)) { 
			coleccionClientes[tamano] = new Cliente(cliente);
			tamano++;

		} else {
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese dni.");

		}
		

	}
	/*método para buscar un cliente en un arreglo, comprueba si el cliente es nulo,
	 si es nulo lanza una excepción. Luego busca el indice del cliente en el arreglo y si el indice es menor que el tamaño del arreglo,
	  devuelve una copia del cliente encontrado, si no devuelve null.*/
	public Cliente buscar(Cliente cliente) { 
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}

		int indice = buscarIndice(cliente);
		if (tamanoSuperado(indice)) {
			return null; 
		} else {

			return new Cliente(coleccionClientes[indice]); 
		}

	}
/*
 * mueve todos los elementos del array una posición hacia la izquierda, a partir de un índice .
 *  usa un for para recorrer el array y mover cada elemento una posición hacia la izquierda,
 *   y establece el último elemento en nulo. Esta función será util para eliminar elementos del array,
 *    ya que desplaza todos los elementos siguientes hacia la izquierda para rellenar el espacio vacío.*/
	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		int i;
		for (i = indice; i < coleccionClientes.length - 1; i++) {

			coleccionClientes[i] = coleccionClientes[i + 1];
		}

		coleccionClientes[i] = null;

	}

	

	

	

	public void borrar(Cliente cliente) throws OperationNotSupportedException {

		if (cliente == null) {

			throw new NullPointerException("error: No se puede borrar un cliente nulo.");
		}

		int indice = buscarIndice(cliente); 

		if (tamanoSuperado(indice)) { 
			
			throw new OperationNotSupportedException("erroR: No existe ningun cliente con esos datos.");
			

		} else {

			desplazarUnaPosicionHaciaIzquierda(indice);
			tamano--;
		}

	}
	public int getCapacidad() { 
		return capacidad;
	}

	public int getTamano() {  
		
		return tamano;
	}
	
	
	
}


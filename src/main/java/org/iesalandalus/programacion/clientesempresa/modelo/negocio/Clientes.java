package org.iesalandalus.programacion.clientesempresa.modelo.negocio;

import org.iesalandalus.programacion.clientesempresa.modelo.dominio.Cliente;

public class Clientes {
private int capacidad;
private int tamano;
 
 public Clientes(int capacidad){
 
}
public void borrar(Cliente cliente) {
	
	
}
public void buscar(Cliente cliente) {
	
}
private int buscarIndice(Cliente cliente) {
	int indice=0;
	return indice;
}
private  boolean capacidadSuperada (int indice) {
	if (indice>tamano) {
		return false;}
	else {return true;}
}
private Cliente copiaProfunda() {
	Cliente[] cliente = null ;
	try {
	for(int i=0;i==tamano;i++) {
		return cliente[i] ;
	}
	}catch(IllegalArgumentException e) {
		return cliente[0];
	}
	return null;
	
}
private void desplazarUnaPosicionHaciaIzquierda(int indice) {
	
}
public Cliente get() {
	Cliente[] cliente = null;
	return cliente[0];
}
public int getCapacidad(){
	
	return capacidad;
}
public int getTamano() {
	return tamano;
}
public void insetar(Cliente cliente) {
	
}
private boolean tamanoSuperado(int indice) {
	if(indice>tamano){
	return false;}else return true;
}
}

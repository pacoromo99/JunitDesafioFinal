package com.nttdata.JUnit1.model;

public class Articulos 
{

	String nombre;
	Double precio;
	
	public Articulos(String nombre, Double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}

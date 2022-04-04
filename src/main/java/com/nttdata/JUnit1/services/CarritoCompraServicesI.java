package com.nttdata.JUnit1.services;

import java.util.List;

import com.nttdata.JUnit1.model.Articulos;

public interface CarritoCompraServicesI 
{
	
	void limpiarCesta();
	void addArticulo(Articulos a);
	Integer getNumArticulos();
	List<Articulos> getArticulos();
	Double totalPrice();
	public Double calculadorDescuento(Double precio, Double porcentaje);
	public Double aplicarDescuento(Integer id, Double porcentaje);
	Integer insertar(Articulos articulo);
}

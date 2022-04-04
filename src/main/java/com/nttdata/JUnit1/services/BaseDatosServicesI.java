package com.nttdata.JUnit1.services;

import com.nttdata.JUnit1.model.Articulos;

public interface BaseDatosServicesI 
{
	public void iniciar();
	public Integer insertarArticulo(Articulos articulo);
	public Articulos buscarArticulo(Integer id);

}

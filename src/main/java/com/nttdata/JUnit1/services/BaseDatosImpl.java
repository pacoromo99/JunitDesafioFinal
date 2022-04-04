package com.nttdata.JUnit1.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nttdata.JUnit1.model.Articulos;

@Service
public class BaseDatosImpl implements BaseDatosServicesI {

	private Map<Integer, Articulos> baseDatos;
	@Override
	public void iniciar() {
		// TODO Auto-generated method stub
		baseDatos = new HashMap<>();
		baseDatos.put(1, new Articulos("Camiseta", 20D));
		baseDatos.put(2, new Articulos("Camiseta 2 ", 21D));
		baseDatos.put(3, new Articulos("Camiseta 3", 22D));
		baseDatos.put(4, new Articulos("Camiseta 4", 23D));
		baseDatos.put(5, new Articulos("Camiseta 5", 24D));
	}

	@Override
	public Integer insertarArticulo(Articulos articulo) {
		baseDatos.put(baseDatos.size()+1, articulo);
		return baseDatos.size();
	}

	@Override
	public Articulos buscarArticulo(Integer id) {
		// TODO Auto-generated method stub
		return baseDatos.get(id);
	}


}

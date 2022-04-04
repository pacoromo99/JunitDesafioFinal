package com.nttdata.JUnit1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.nttdata.JUnit1.model.Articulos;

public class CarritoCompraServicesImpl implements CarritoCompraServicesI {

	@Autowired
	private BaseDatosServicesI baseDatos;
	private List<Articulos> cesta = new ArrayList<>();

	@Override
	public void limpiarCesta() {
		cesta.clear();

	}

	@Override
	public void addArticulo(Articulos articulo) {
		cesta.add(articulo);

	}

	@Override
	public Integer getNumArticulos() {
		// TODO Auto-generated method stub
		return cesta.size();
	}

	@Override
	public List<Articulos> getArticulos() {
		// TODO Auto-generated method stub
		return cesta;
	}

	@Override
	public Double totalPrice() {

		Double total = 0D;
		for (Articulos articulo : cesta) {
			total = total + articulo.getPrecio();

		}
		return total;
	}

	@Override
	public Double calculadorDescuento(Double precio, Double porcentaje) {

		return precio - precio * porcentaje / 100;
	}

	@Override
	public Double aplicarDescuento(Integer id, Double porcentaje) {
		// TODO Auto-generated method stub
		Articulos articulo = baseDatos.buscarArticulo(id);
		if (Optional.ofNullable(articulo).isPresent()) {
			return calculadorDescuento(articulo.getPrecio(), porcentaje);

		} else {
			System.out.println("no se ha encontrado");
		}
		return 0D;
	}

	@Override
	public Integer insertar(Articulos articulo) {
		cesta.add(articulo);
		return baseDatos.insertarArticulo(articulo);
	}

}

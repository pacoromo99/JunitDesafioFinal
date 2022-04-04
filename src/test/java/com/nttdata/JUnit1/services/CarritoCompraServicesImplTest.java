package com.nttdata.JUnit1.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nttdata.JUnit1.model.Articulos;

@ExtendWith(MockitoExtension.class)


class CarritoCompraServicesImplTest {

@InjectMocks
	CarritoCompraServicesImpl carrito = new CarritoCompraServicesImpl();
	@Mock
	private BaseDatosServicesI baseDatos;
	@Test
	void testLimpiarCesta() {
		
		carrito.addArticulo(new Articulos("Camiseta", 15.50));
		assertFalse(carrito.getArticulos().isEmpty());
		carrito.limpiarCesta();
		assertTrue(carrito.getArticulos().isEmpty());
	}

	@Test
	void testAddArticulo() {
		assertTrue(carrito.getArticulos().isEmpty());
		carrito.addArticulo(new Articulos("Camiseta", 15.50));
		assertFalse(carrito.getArticulos().isEmpty());
	}

	@Test
	void testGetNumArticulos() {
		carrito.addArticulo(new Articulos("Camiseta", 15.50));
		carrito.addArticulo(new Articulos("pantalon", 15.50));
		Integer res = carrito.getNumArticulos();
		assertEquals(Integer.valueOf(2), res);
	}

	@Test
	public void testGetArticulos() {
		carrito.addArticulo(new Articulos("Camiseta",18.99));
		carrito.addArticulo(new Articulos("Pantalón",20.99));
		List<Articulos> res = carrito.getArticulos();
		assertEquals("Camiseta", res.get(0).getNombre());
		assertEquals(2, res.size());
		}

	@Test
	void testTotalPrice() {
		carrito.addArticulo(new Articulos("Camiseta", 15.50));
		carrito.addArticulo(new Articulos("pantalon", 15.50));
		carrito.addArticulo(new Articulos("chaqueta", 15.50));
		assertEquals(46.50, carrito.totalPrice());
	
	}

	@Test
	void testCalculadorDescuento() {
		carrito.addArticulo(new Articulos("Camiseta", 100D));
		assertEquals(75, carrito.calculadorDescuento(100D, 25D));
		
		
	}
	@Test
	void testAplicarDescuento() 
	{
		Articulos articulo = new Articulos("Camiseta", 100D);
		when(baseDatos.buscarArticulo(any(Integer.class))).thenReturn(articulo);
		Double res = carrito.aplicarDescuento(1, 10D);
		assertEquals(90, res);
	}
	@Test
	void testInsertar()
	{
	
		Articulos articulo = new Articulos("Camiseta", 100D);
		when(baseDatos.insertarArticulo(articulo)).thenReturn(1);
		Integer res = carrito.insertar(articulo);
		assertEquals(1, res);	
		//comprobar lista
		assertEquals(carrito.getArticulos().get(0).getNombre(), "Camiseta");
		//comprobar llamada a la bd
		verify(baseDatos, times(1)).insertarArticulo(articulo);
	}

}

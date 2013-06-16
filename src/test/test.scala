package test

import org.scalatest._
import org.junit.Assert._
import org.junit.Test
import org.junit.Before
import org.junit.After
import java.util.Date
import recital._

class PrecioEntradaTest extends AssertionsForJUnit {
  
  @Before
  var jubilado = new Jubilado(precioDescuento: 50);
  var menor = new Menor(precioDescuento: 30);
  var mayor = new Mayor(precioDescuento: 10);
	
  var sectorA = new Sector(nombre: "a");
	
  var fila1a10 = new  RangoFilas(desde: 1, hasta:10, precio: 100, cantidadAsientos: 20);
  var fila11a20 = new  RangoFilas(desde: 11, hasta:20, precio: 70, cantidadAsientos: 20);
	
  sectorA.filas += fila1a10;
  sectorA.filas += fila11a20;
		
  var noche1 = new Noche(fecha: "25/12/13");
  
  var internacional = new CategoriaBanda(tipo: "internacional", precioExtra: 100);
  var acdc = new Banda(nombre: "acdc", categoria: internacional);
 
  noche1.bandas += acdc;
	
  var coreVentas = new CoreVentas();
  coreVentas.noches += noche1;
  
  @Test
  
  
  
  @After 
  def vaciarEntradas {
    coreVentas.entradas.empty
  }
  
}
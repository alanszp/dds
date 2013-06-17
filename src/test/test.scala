package test

import org.scalatest.junit._
import org.junit.Assert._
import org.junit.Test
import org.junit.Before
import org.junit.After
import java.util.Date
import recital._

class PrecioEntradaTest extends AssertionsForJUnit {
  
  @Before
  var jubilado = new Jubilado(50)
  var menor = new Menor(30,10)
  var mayor = new Mayor(10)
	
  var sectorA = new Sector("a",100)
	
  var fila1a10 = new  RangoFilas(1, 10, 100, 20)
  var fila11a20 = new  RangoFilas(11, 20, 70, 20)
	
  sectorA.filas += fila1a10
  sectorA.filas += fila11a20
		
  var noche1 = new Noche("25/12/13")
  
  var internacional = new CategoriaBanda("internacional", 100)
  var acdc = new Banda("acdc", internacional)
 
  noche1.bandas += acdc
	
  var coreDeVentas = new CoreDeVentas
  coreDeVentas.noches += noche1
  
  @Test
  def testPrueba {
    assertTrue("prueba", 1==1)
  }
  
  
  @After 
  def vaciarEntradas {
    coreDeVentas.entradas.empty
  }
  
}
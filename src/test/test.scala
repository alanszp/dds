package test

import org.scalatest.junit._
import org.junit.Assert._
import org.junit.Test
import org.junit.Before
import org.junit.After
import recital._

class test extends AssertionsForJUnit {
  
  @Before
  var jubilado = new Jubilado(0.15)
  var menor = new Menor(10,0.2)
  var mayor = new Mayor
	
  var sectorA = new Sector("A")
	
  var fila1a10 = new RangoFilas(1, 10, 150, 20)
  var fila11a20 = new RangoFilas(11, 20, 70, 20)
	
  sectorA.filas += fila1a10
  sectorA.filas += fila11a20
		
  var noche1 = new Noche("25/12/13")
  var noche2 = new Noche("26/12/13")
  
  var categoria_nacionalPocoReconocida = new CategoriaBanda("Nacional Poco Reconocida", 0)
  var categoria_nacionalReconocida = new CategoriaBanda("Nacional Reconocida", 50)
  var categoria_nacionalReconocidaInternacionalmente = new CategoriaBanda("Nacional Reconocida Internacionalmente", 100)
  var categoria_internacional = new CategoriaBanda("Internacional", 200)
  
  var acdc = new Banda("acdc", categoria_internacional)
  var wachiturros = new Banda("acdc", categoria_nacionalPocoReconocida)
 
  noche1.bandas += acdc
  noche1.bandas += wachiturros
  
  noche2.bandas += wachiturros
  
  var coreDeVentas = new CoreDeVentas
  coreDeVentas.noches += noche1
  
  @Test
  def testFilas {
	println(fila1a10.tengoFila(50))
    assertTrue(fila1a10.tengoFila(10))
    assertTrue(fila1a10.tengoFila(5))
    assertTrue(fila1a10.tengoFila(1))
    
    assertFalse(fila1a10.tengoFila(15))
    assertFalse(fila1a10.tengoFila(0))
  }
  
  @Test
  def testPrecioExtraPorNoche {
	  assertTrue(noche1.valorExtra == 200)
	  assertTrue(noche2.valorExtra == 0)
  }
  
  @Test
  def testCategorias {
	  assertTrue(mayor.aplicarDescuento(100) == 0)
	  
	  assertTrue(jubilado.aplicarDescuento(100)== 15)
	  
	  assertTrue(menor.aplicarDescuento(101) == 20.2)
	  assertTrue(menor.aplicarDescuento(100) == 10)
	  assertTrue(menor.aplicarDescuento(75) == 10)
	  assertTrue(menor.aplicarDescuento(50) == 0)
	  assertTrue(menor.aplicarDescuento(40) == 0)
	  assertTrue(menor.aplicarDescuento(110) == 22)
  }
  
  @Test
  def precioEntradaMayorCorrecto {
    var entrada = new Entrada(sectorA, noche1, mayor, 10, 2)
    var entrada2 = new Entrada(sectorA, noche1, mayor, 15, 2)
    var entrada3 = new Entrada(sectorA, noche2, mayor, 10, 2)
    var entrada4 = new Entrada(sectorA, noche2, mayor, 15, 2)
    
    assertTrue("Precio entrada mayor correcto", entrada.precioEntrada == 350)    
    assertTrue("Precio entrada mayor correcto", entrada2.precioEntrada == 270)   
    assertTrue("Precio entrada mayor correcto", entrada3.precioEntrada == 150)    
    assertTrue("Precio entrada mayor correcto", entrada4.precioEntrada == 70)   
  }
  
  @Test
  def precioEntradaMenorCorrecto {
    var entrada = new Entrada(sectorA, noche1, menor, 10, 2)
    var entrada2 = new Entrada(sectorA, noche1, menor, 15, 2)
    var entrada3 = new Entrada(sectorA, noche2, menor, 10, 2)
    var entrada4 = new Entrada(sectorA, noche2, menor, 15, 2)
    
    assertTrue("Precio entrada Menor correcto", entrada.precioEntrada == 320)
    assertTrue("Precio entrada Menor correcto", entrada2.precioEntrada == 260)  
    assertTrue("Precio entrada Menor correcto", entrada3.precioEntrada == 120)    
    assertTrue("Precio entrada Menor correcto", entrada4.precioEntrada == 60)
  }
  
  @Test
  def precioEntradaJubiladoCorrecto {
    var entrada = new Entrada(sectorA, noche1, jubilado, 10, 2)
    var entrada2 = new Entrada(sectorA, noche1, jubilado, 15, 2)
    var entrada3 = new Entrada(sectorA, noche2, jubilado, 10, 2)
    var entrada4 = new Entrada(sectorA, noche2, jubilado, 15, 2)
    
    assertTrue("Precio entrada jubilado correcto", entrada.precioEntrada == 327.5)   
    assertTrue("Precio entrada jubilado correcto", entrada2.precioEntrada == 259.5)  
    assertTrue("Precio entrada jubilado correcto", entrada3.precioEntrada == 127.5)    
    assertTrue("Precio entrada jubilado correcto", entrada4.precioEntrada == 59.5)
  }
      

  
  @After 
  def vaciarEntradas {
    coreDeVentas.entradas.empty
  }
  
}
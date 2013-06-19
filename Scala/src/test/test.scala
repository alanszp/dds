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
  var damas = new Damas(0.2)
  var menor12 = new Menor12(0.5)
	
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
  def testPrecioExtraPorNoche_conCambiosDinamicos {
	  assertTrue(noche1.valorExtra == 200)
	  acdc.categoria = categoria_nacionalReconocidaInternacionalmente
	  assertTrue(noche1.valorExtra == 100)
	  acdc.categoria = categoria_nacionalReconocida
	  assertTrue(noche1.valorExtra == 50)
	  wachiturros.categoria = categoria_internacional //ironia
	  assertTrue(noche1.valorExtra == 200)
  }
  
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
	  assertDescuentoCategoria("Categoria calcula bien descuento", mayor, 100, 0)
	  
	  assertDescuentoCategoria("Categoria calcula bien descuento", jubilado, 100, 15)
	  
	  assertDescuentoCategoria("Categoria calcula bien descuento", menor, 101, 20.2)
	  assertDescuentoCategoria("Categoria calcula bien descuento", menor, 100, 10)
	  assertDescuentoCategoria("Categoria calcula bien descuento", menor, 75, 10)
	  assertDescuentoCategoria("Categoria calcula bien descuento", menor, 50, 0)
	  assertDescuentoCategoria("Categoria calcula bien descuento", menor, 40, 0)
	  assertDescuentoCategoria("Categoria calcula bien descuento", menor, 110, 22)
	  assertDescuentoCategoria("Categoria calcula bien descuento", damas, 100, 80)
	  assertDescuentoCategoria("Categoria calcula bien descuento", damas, 40, 32)
	  assertDescuentoCategoria("Categoria calcula bien descuento", menor12, 40, 20)
	  assertDescuentoCategoria("Categoria calcula bien descuento", menor12, 0, 0)
  }
  
  @Test
  def precioEntradaMayorCorrecto {
    var entrada = new Entrada(sectorA, noche1, mayor, 10, 2)
    var entrada2 = new Entrada(sectorA, noche1, mayor, 15, 2)
    var entrada3 = new Entrada(sectorA, noche2, mayor, 10, 2)
    var entrada4 = new Entrada(sectorA, noche2, mayor, 15, 2)
    
    assertPrecioEntrada("Precio entrada mayor correcto", entrada, 350)    
    assertPrecioEntrada("Precio entrada mayor correcto", entrada2, 270)   
    assertPrecioEntrada("Precio entrada mayor correcto", entrada3, 150)    
    assertPrecioEntrada("Precio entrada mayor correcto", entrada4, 70)   
  }
  
  @Test
  def precioEntradaMenorCorrecto {
    var entrada = new Entrada(sectorA, noche1, menor, 10, 2)
    var entrada2 = new Entrada(sectorA, noche1, menor, 15, 2)
    var entrada3 = new Entrada(sectorA, noche2, menor, 10, 2)
    var entrada4 = new Entrada(sectorA, noche2, menor, 15, 2)
    
    assertPrecioEntrada("Precio entrada Menor correcto", entrada, 320)
    assertPrecioEntrada("Precio entrada Menor correcto", entrada2, 260)  
    assertPrecioEntrada("Precio entrada Menor correcto", entrada3, 120)    
    assertPrecioEntrada("Precio entrada Menor correcto", entrada4, 60)
  }
  
  @Test
  def precioEntradaJubiladoCorrecto {
    var entrada = new Entrada(sectorA, noche1, jubilado, 10, 2)
    var entrada2 = new Entrada(sectorA, noche1, jubilado, 15, 2)
    var entrada3 = new Entrada(sectorA, noche2, jubilado, 10, 2)
    var entrada4 = new Entrada(sectorA, noche2, jubilado, 15, 2)
    
    assertPrecioEntrada("Precio entrada jubilado correcto", entrada, 327.5)   
    assertPrecioEntrada("Precio entrada jubilado correcto", entrada2, 259.5)  
    assertPrecioEntrada("Precio entrada jubilado correcto", entrada3, 127.5)    
    assertPrecioEntrada("Precio entrada jubilado correcto", entrada4, 59.5)
  }
  
  @Test
  def coreEstaVacioAlIniciar {
    assertCantidadEntradasVendidas("Hay 0 entradas al iniciar el core", coreDeVentas, 0)
  }
  
  @Test
  def venderEntradaCorrectamente {
	var entrada = new Entrada(sectorA, noche1, menor, 10, 2)
	var entrada2 = new Entrada(sectorA, noche1, menor, 10, 3)
	
	coreDeVentas.venderEntrada(entrada)
	assertHayEntradaVendida("Aseguro que la entrada se haya registrado", coreDeVentas, entrada)
	
	coreDeVentas.venderEntrada(entrada2)
	assertHayEntradaVendida("Aseguro que la entrada se haya registrado", coreDeVentas, entrada)
	assertHayEntradaVendida("Aseguro que la entrada se haya registrado", coreDeVentas, entrada2)
	assertCantidadEntradasVendidas("Me aseguro que hayan dos entradas", coreDeVentas, 2)
  }
  
  @Test
  def testNoSePuedeVenderDosEntradasIguales {
	  var entrada = new Entrada(sectorA, noche1, menor, 10, 2)
    try {
    	coreDeVentas.venderEntrada(entrada)      
    	coreDeVentas.venderEntrada(entrada)
    	fail()
    }
    catch { 
    	case e: EntradaExistenteException => {
    	  assertHayEntradaVendida("Aseguro que la entrada se haya registrado", coreDeVentas, entrada)
    	  assertCantidadEntradasVendidas("Me fijo que haya 1 sola entrada", coreDeVentas, 1)
    	  }
     }
	
  }
  
  
  def assertPrecioEntrada(msg: String, entrada: Entrada, precio: Double) {
    assertEquals(msg, entrada.precioEntrada, precio, 0.01)
  }
  
  def assertDescuentoCategoria(msg: String, categoria: CategoriaPersona, entradaBase: Double, precio: Double) {
    assertEquals(msg, categoria.aplicarDescuento(entradaBase), precio, 0.01)
  }
  
  def assertHayEntradaVendida(msg:String, coreDeVentas:CoreDeVentas, entrada:Entrada) {
    assertTrue(msg, coreDeVentas.existeEntrada(entrada))
  }
  
  def assertCantidadEntradasVendidas(msg:String, coreDeVentas:CoreDeVentas, cantidad:Int) {
    assertEquals(msg, coreDeVentas.cantidadEntradasVendidas, cantidad)
    
  }
  
}
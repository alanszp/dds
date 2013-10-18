package test

import org.scalatest.junit._
import org.junit.Assert._
import org.junit.Test
import org.junit.Before
import org.junit.After
import recital._

class testCompleto extends AssertionsForJUnit {
  
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
  noche1.descuentos = noche1.descuentos union Set(jubilado, menor, mayor, damas, menor12)
  
  noche2.bandas += wachiturros
  noche2.descuentos = noche2.descuentos union Set(jubilado, menor, mayor, damas, menor12)
  
  var coreDeVentas = new CoreDeVentas
  coreDeVentas.noches += noche1
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
	  assertDescuentoCategoria("Categoria calcula mal descuento", mayor, 100, 0)
	  
	  assertDescuentoCategoria("Categoria calcula mal descuento", jubilado, 100, 15)
	  
	  assertDescuentoCategoria("Categoria calcula mal descuento", menor, 101, 20.2)
	  assertDescuentoCategoria("Categoria calcula mal descuento", menor, 100, 10)
	  assertDescuentoCategoria("Categoria calcula mal descuento", menor, 75, 10)
	  assertDescuentoCategoria("Categoria calcula mal descuento", menor, 50, 0)
	  assertDescuentoCategoria("Categoria calcula mal descuento", menor, 40, 0)
	  assertDescuentoCategoria("Categoria calcula mal descuento", menor, 110, 22)
	  
	  assertDescuentoCategoria("Categoria calcula mal descuento", damas, 100, 20)
	  assertDescuentoCategoria("Categoria calcula mal descuento", damas, 40, 8)
	  
	  assertDescuentoCategoria("Categoria calcula mal descuento", menor12, 40, 20)
	  assertDescuentoCategoria("Categoria calcula mal descuento", menor12, 0, 0)
  }
  
  @Test
  def testNocheNoTieneDescuentoApropiado {
    var jubilado2 = new Jubilado(0.3)
    try {
      var entrada = new Entrada(sectorA, noche1, jubilado2, 10, 2, "Pepe")
      fail("No tendria que haberse creado la entrada")
    }
    catch {
      case e: CategoriaNoValidaException => //Todo oka!
    }
  }
  
  @Test
  def precioEntradaMayorCorrecto {
    var entrada = new Entrada(sectorA, noche1, mayor, 10, 2, "Pepe")
    var entrada2 = new Entrada(sectorA, noche1, mayor, 15, 2, "Pepe")
    var entrada3 = new Entrada(sectorA, noche2, mayor, 10, 2, "Pepe")
    var entrada4 = new Entrada(sectorA, noche2, mayor, 15, 2, "Pepe")
    
    assertPrecioEntrada("Precio entrada mayor incorrecto", entrada, 350)    
    assertPrecioEntrada("Precio entrada mayor incorrecto", entrada2, 270)   
    assertPrecioEntrada("Precio entrada mayor incorrecto", entrada3, 150)    
    assertPrecioEntrada("Precio entrada mayor incorrecto", entrada4, 70)   
  }
  
  @Test
  def precioEntradaMenorCorrecto {
    var entrada = new Entrada(sectorA, noche1, menor, 10, 2, "Pepe")
    var entrada2 = new Entrada(sectorA, noche1, menor, 15, 2, "Pepe")
    var entrada3 = new Entrada(sectorA, noche2, menor, 10, 2, "Pepe")
    var entrada4 = new Entrada(sectorA, noche2, menor, 15, 2, "Pepe")
    
    assertPrecioEntrada("Precio entrada Menor incorrecto", entrada, 320)
    assertPrecioEntrada("Precio entrada Menor incorrecto", entrada2, 260)  
    assertPrecioEntrada("Precio entrada Menor incorrecto", entrada3, 120)    
    assertPrecioEntrada("Precio entrada Menor incorrecto", entrada4, 60)
  }
  
  @Test
  def precioEntradaJubiladoCorrecto {
    var entrada = new Entrada(sectorA, noche1, jubilado, 10, 2, "Pepe")
    var entrada2 = new Entrada(sectorA, noche1, jubilado, 15, 2, "Pepe")
    var entrada3 = new Entrada(sectorA, noche2, jubilado, 10, 2, "Pepe")
    var entrada4 = new Entrada(sectorA, noche2, jubilado, 15, 2, "Pepe")
    
    assertPrecioEntrada("Precio entrada jubilado incorrecto", entrada, 327.5)   
    assertPrecioEntrada("Precio entrada jubilado incorrecto", entrada2, 259.5)  
    assertPrecioEntrada("Precio entrada jubilado incorrecto", entrada3, 127.5)    
    assertPrecioEntrada("Precio entrada jubilado incorrecto", entrada4, 59.5)
  }
  
  @Test
  def coreEstaVacioAlIniciar {
    assertCantidadEntradasVendidas("No hay 0 entradas al iniciar el core", coreDeVentas, 0)
  }
  
  @Test
  def venderEntradaCorrectamente {
	var entrada = new Entrada(sectorA, noche1, menor, 10, 2, "Pepe")
	var entrada2 = new Entrada(sectorA, noche1, menor, 10, 3, "Pepe")
	
	coreDeVentas.venderEntrada(entrada)
	assertHayEntradaVendida("No se agrego la entrada1", coreDeVentas, entrada)
	
	coreDeVentas.venderEntrada(entrada2)
	assertHayEntradaVendida("Se borro inesperadamente la entrada1", coreDeVentas, entrada)
	assertHayEntradaVendida("No se agrego la entrada2", coreDeVentas, entrada2)
	assertCantidadEntradasVendidas("Tiene que haber 2 sola entrada", coreDeVentas, 2)
  }
  
  @Test
  def venderComboEntradaCorrectamente {
	var entrada1 = new Entrada(sectorA, noche1, menor, 10, 2, "Pepe")
	var entrada2 = new Entrada(sectorA, noche1, menor, 10, 3, "Pepe")
	var entrada3 = new Entrada(sectorA, noche1, menor, 10, 4, "Pepe")
	var entrada4 = new Entrada(sectorA, noche1, menor, 10, 5, "Pepe")
	var comboEntrada1 = new ComboEntrada(0.2)
	var comboEntrada2 = new ComboEntrada(0.2)
	comboEntrada1.agregar(entrada1)
	comboEntrada1.agregar(entrada2)
	comboEntrada2.agregar(entrada3)
	comboEntrada2.agregar(entrada4)
	
	coreDeVentas.venderEntrada(comboEntrada1)
	assertHayEntradaVendida("Aseguro que la entrada1 se haya registrado", coreDeVentas, entrada1)
	assertHayEntradaVendida("Aseguro que la entrada2 se haya registrado", coreDeVentas, entrada2)
	assertCantidadEntradasVendidas("Me aseguro que hayan dos entradas", coreDeVentas, 2)
	
	coreDeVentas.venderEntrada(comboEntrada2)
	assertHayEntradaVendida("Aseguro que la entrada1 se haya registrado", coreDeVentas, entrada1)
	assertHayEntradaVendida("Aseguro que la entrada2 se haya registrado", coreDeVentas, entrada2)
	assertHayEntradaVendida("Aseguro que la entrada3 se haya registrado", coreDeVentas, entrada3)
	assertHayEntradaVendida("Aseguro que la entrada4 se haya registrado", coreDeVentas, entrada4)
	assertCantidadEntradasVendidas("Tiene que haber 4 sola entrada", coreDeVentas, 4)
  }
  
  @Test
  def testNoSePuedeVenderDosEntradasIguales {
	  var entrada = new Entrada(sectorA, noche1, menor, 10, 2, "Pepe")
    try {
    	coreDeVentas.venderEntrada(entrada)      
    	coreDeVentas.venderEntrada(entrada)
    	fail("Se vendio correctamente dos entradas... Algo falla!")
    }
    catch { 
    	case e: EntradaExistenteException => {
    	  assertHayEntradaVendida("No se agrego la entrada", coreDeVentas, entrada)
    	  assertCantidadEntradasVendidas("Tiene que haber 1 sola entrada", coreDeVentas, 1)
    	  }
     }
  }
  
  @Test
  def testNoSePuedeVenderDosComboDeEntradasIguales {
	var entrada1 = new Entrada(sectorA, noche1, menor, 10, 2, "Pepe")
	var entrada2 = new Entrada(sectorA, noche1, menor, 10, 3, "Pepe")
	var entrada3 = new Entrada(sectorA, noche1, menor, 10, 4, "Pepe")
	var entrada4 = new Entrada(sectorA, noche1, menor, 10, 5, "Pepe")
	var comboEntrada1 = new ComboEntrada(0.2)
  	var comboEntrada2 = new ComboEntrada(0.2)
	comboEntrada1.agregar(entrada1)
	comboEntrada1.agregar(entrada2)
	comboEntrada2.agregar(entrada2)
	comboEntrada2.agregar(entrada3)

    try {
    	coreDeVentas.venderEntrada(comboEntrada1)      
    	coreDeVentas.venderEntrada(comboEntrada1)
    	fail("Se vendio correctamente dos entradas iguales...")
    }
    catch { 
    	case e: EntradaExistenteException => {
    	  assertHayEntradaVendida("No se agrego la entrada1", coreDeVentas, entrada1)
    	  assertHayEntradaVendida("No se agrego la entrada2", coreDeVentas, entrada2)
    	  assertCantidadEntradasVendidas("Tiene que haber 2 sola entrada", coreDeVentas, 2)
    	  }
    }
  }
  
  @Test 
  def testNoSePuedeVenderDosCombosConUnaEntradaEquivalente {
    var entrada1 = new Entrada(sectorA, noche1, menor, 10, 2, "Pepe")
	var entrada2 = new Entrada(sectorA, noche1, menor, 10, 3, "Pepe")
	var entrada3 = new Entrada(sectorA, noche1, menor, 10, 4, "Pepe")
	var comboEntrada1 = new ComboEntrada(0.2)
  	var comboEntrada2 = new ComboEntrada(0.2)
	comboEntrada1.agregar(entrada1)
	comboEntrada1.agregar(entrada2)
	comboEntrada2.agregar(entrada2)
	comboEntrada2.agregar(entrada3)
    
    try {
      coreDeVentas.venderEntrada(comboEntrada1)      
      coreDeVentas.venderEntrada(comboEntrada2)
      fail("Se vendio correctamente dos Combo de Entradas que tenian la misma entrada...")
    }
    catch {
      case e: EntradaExistenteException => {
        assertHayEntradaVendida("No se agrego la entrada1", coreDeVentas, entrada1)
        assertHayEntradaVendida("No se agrego la entrada2", coreDeVentas, entrada2)
        assertNoHayEntradaVendida("Se agrego la entrada3 y no tenia que agregarse", coreDeVentas, entrada3)
        assertCantidadEntradasVendidas("Tiene que haber 2 sola entrada", coreDeVentas, 2)
      }
    }
  }
  
  @Test 
  def testNoSePuedeVenderUnComboCuandoYaExisteUnaDeSusEntradas {
    var entrada1 = new Entrada(sectorA, noche1, menor, 10, 2, "Pepe")
	var entrada2 = new Entrada(sectorA, noche1, menor, 10, 3, "Pepe")
	var comboEntrada1 = new ComboEntrada(0.2)
	comboEntrada1.agregar(entrada1)
	comboEntrada1.agregar(entrada2)

    try {
      coreDeVentas.venderEntrada(entrada1)
      coreDeVentas.venderEntrada(comboEntrada1)      
      fail("Se vendio correctamente un Combo de Entrada cuadno ya existia una de esas...")
    }
    catch {
      case e: EntradaExistenteException => {
        assertHayEntradaVendida("No se agrego la entrada1", coreDeVentas, entrada1)
        assertNoHayEntradaVendida("Se agrego la entrada 2 y no tenia que agregarse", coreDeVentas, entrada2)
        assertCantidadEntradasVendidas("Tiene que haber 1 sola entrada", coreDeVentas, 1)
      }
    }
  }
  
  @Test 
  def testNoSePuedeVenderUnaEntradaCuandoYaExisteUnComboQueLaTenga {
    var entrada1 = new Entrada(sectorA, noche1, menor, 10, 2, "Pepe")
	var entrada2 = new Entrada(sectorA, noche1, menor, 10, 3, "Pepe")
	var comboEntrada1 = new ComboEntrada(0.2)
	comboEntrada1.agregar(entrada1)
	comboEntrada1.agregar(entrada2)

    try {
      coreDeVentas.venderEntrada(comboEntrada1)      
      coreDeVentas.venderEntrada(entrada1)
      fail("Se vendio correctamente un Combo de Entrada cuadno ya existia una de esas...")
    }
    catch {
      case e: EntradaExistenteException => {
        assertHayEntradaVendida("No se agrego la entrada1", coreDeVentas, entrada1)
        assertHayEntradaVendida("Se agrego la entrada 2 y no tenia que agregarse", coreDeVentas, entrada2)
        assertCantidadEntradasVendidas("Tiene que haber 2 sola entrada", coreDeVentas, 2)
      }
    }
   
  }
  
  @Test
  def testInstancioUnaEntradaConUbicacionIncorrecta {
	//Pruebo fila erronea 
    try {
      var entrada1 = new Entrada(sectorA, noche1, menor, 60, 2, "Pepe")
      fail("Se instancio una entrada con una fila erronea")
    }
    catch {
      case e: FilaIncorrectaException => //Se esperaba esto!
    }
  
    //Pruebo fila y asiento erroneos
    try {
      var entrada2 = new Entrada(sectorA, noche1, menor, 60, 100, "Pepe")
      fail("Se instancio una entrada con una fila y asiento erroneo")
    }
    catch {
      case e: FilaIncorrectaException => //Se esperaba esto! --> Salta primero el FilaIncorrectaException, antes que el AsientoIncorrectoException. Si es al revez, hay algo mal :D
    }
    
    //Pruebo asiento erroneo
    try {
      var entrada3 = new Entrada(sectorA, noche1, menor, 10, 100, "Pepe")
      fail("Se instancio una entrada con un asiento erroneo")
    }
    catch {
      case e: AsientoIncorrectoException => //Se esperaba esto!
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
  
  def assertNoHayEntradaVendida(msg:String, coreDeVentas:CoreDeVentas, entrada:Entrada) {
    assertTrue(msg, !coreDeVentas.existeEntrada(entrada))
  }
  
  def assertCantidadEntradasVendidas(msg:String, coreDeVentas:CoreDeVentas, cantidad:Int) {
    assertEquals(msg,cantidad, coreDeVentas.cantidadEntradasVendidas)
    
  }
  
}
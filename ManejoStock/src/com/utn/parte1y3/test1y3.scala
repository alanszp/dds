package com.utn.parte1y3

import org.scalatest.junit._
import org.junit.Assert._
import org.junit.Test
import org.junit.Before
import org.junit.After
import com.utn.comun._
import scala.collection.immutable.Map
import java.util.Dictionary
import scala.collection.immutable.HashMap



class test1y3 extends  AssertionsForJUnit {
  
  @Before
  var deposito = new Deposito
  var produccion = new Produccion
  
  var reservarSinFabricar = new ReservarSinFabricar
  var reservarFabricando = new ReservarFabricando
  
  var fabrica = new Fabrica(deposito, produccion)
  
  deposito.setFabrica(fabrica)
  produccion.setFabrica(fabrica)
  
  var factoryMateriaPrima = new FactoryMateriaPrima
  
  var listaChapa = List("molde de aluminio", "molde de aluminio", "molde de zinc", "molde de zinc", "molde de tungsteno")
  var factoryChapa = new FactoryCompuesto(listaChapa)
  
  var listaPuerta = List("vidrio", "chapa")
  var factoryPuerta = new FactoryCompuesto(listaPuerta)
  
  var listaAuto = List("volante", "motor", "puerta", "puerta", "puerta", "puerta", "carroceria", "asiento", "asiento", "asiento", "asiento")
  var factoryAuto = new FactoryProducto(listaAuto)
  
  var diccionarioCompuestos = Map("auto"->factoryAuto, "chapa"->factoryChapa, "puerta"->factoryPuerta)
  produccion.setDiccionario(diccionarioCompuestos)
  
  
  @Test
  def testSiCreaDepositoVacio {
    assertStock(List())
    assertReservas(List())
  }
  
  @Test
  def testCreaMateriaPrima {
    var mPrima = factoryMateriaPrima.crear("caño", produccion)
    
    assertMateriaPrima(mPrima, "caño")
  }
  
  @Test
  def testCrearCompuestoSiNoHayStock {
    var chapa = factoryChapa.crear("chapa", produccion)
    assertCompuesto(chapa, "chapa", listaChapa, List())
    
    var puerta = factoryPuerta.crear("puerta", produccion)
    assertCompuesto(puerta, "puerta", listaPuerta, List())
    
    var auto = factoryAuto.crear("auto", produccion)
    assertCompuesto(auto, "auto", listaAuto, List())
    
  }
  
  @Test
  def testCrearCompuestoConTodoElStock {
    deposito.agregarFabricados(factoryMateriaPrima.crear("vidrio", produccion))
    deposito.agregarFabricados(factoryChapa.crear("chapa", produccion))
    
    var puerta = factoryPuerta.crear("puerta", produccion)
    
    assertCompuesto(puerta, "puerta", List(), listaPuerta)
    assertStock(List())
  }
  
  @Test
  def testCrearCompuestoConAlgoDeStock {
    deposito.agregarFabricados(factoryMateriaPrima.crear("vidrio", produccion))
    var puerta = factoryPuerta.crear("puerta", produccion)
    
    assertCompuesto(puerta, "puerta", List("chapa"), List("vidrio"))
    assertStock(List())
  }
  
  
  @Test
  def testDescuentaYAgregaBienDeStock {
    deposito.agregarFabricados(factoryMateriaPrima.crear("vidrio", produccion))
    deposito.agregarFabricados(factoryChapa.crear("chapa", produccion))
    deposito.agregarFabricados(factoryChapa.crear("chapa", produccion))
    deposito.agregarFabricados(factoryMateriaPrima.crear("vidrio", produccion))
    
    assertStock(List("vidrio","vidrio","chapa","chapa"))
    
    var puerta = factoryPuerta.crear("puerta", produccion)
    
    assertCompuesto(puerta, "puerta", List(), listaPuerta)
    assertStock(List("vidrio","chapa"))
    
    deposito.agregarFabricados(factoryMateriaPrima.crear("llantas", produccion))
    assertStock(List("vidrio", "llantas", "chapa"))
    
    deposito.agregarFabricados(factoryMateriaPrima.crear("llantas", produccion))
    assertStock(List("vidrio", "llantas", "chapa", "llantas"))
  }

  @Test
  def testHayStockDisponibleParaCrear {
    deposito.agregarFabricados(factoryMateriaPrima.crear("vidrio", produccion))
    deposito.agregarFabricados(factoryMateriaPrima.crear("molde de aluminio", produccion))
    deposito.agregarFabricados(factoryMateriaPrima.crear("molde de aluminio", produccion))
    deposito.agregarFabricados(factoryMateriaPrima.crear("molde de zinc", produccion))
    deposito.agregarFabricados(factoryMateriaPrima.crear("molde de zinc", produccion))
    deposito.agregarFabricados(factoryMateriaPrima.crear("molde de tungsteno", produccion))
    
    assertTrue("Dice que no puede, pero puede", produccion.chequearQueTieneTodo("puerta"))
    
    deposito.agregarFabricados(factoryAuto.crear("auto", produccion))
    assertTrue("Dice que no puede, pero puede", produccion.chequearQueTieneTodo("auto"))
  }
  
  @Test
  def testNoHayStockDisponibleParaCrear {
    deposito.agregarFabricados(factoryMateriaPrima.crear("vidrio", produccion))
    deposito.agregarFabricados(factoryMateriaPrima.crear("molde de aluminio", produccion))
    deposito.agregarFabricados(factoryMateriaPrima.crear("molde de aluminio", produccion))
    deposito.agregarFabricados(factoryMateriaPrima.crear("molde de zinc", produccion))
    deposito.agregarFabricados(factoryMateriaPrima.crear("molde de zinc", produccion))
    
    assertFalse("Dice que puede, pero no puede", produccion.chequearQueTieneTodo("puerta"))
    
    assertFalse("Dice que no puede, pero puede", produccion.chequearQueTieneTodo("auto"))
  }
  
  
  @Test
  def testReservarAutoFabricando {
    deposito.agregarFabricados(factoryMateriaPrima.crear("volante", produccion))
    
	fabrica.setTipoReserva(reservarFabricando)
    
	fabrica.reservar("auto")
    assertReservas(List("auto"))
    assertStock(List())
    var auto = deposito.quitarReservados("auto")
    assertCompuesto(auto.asInstanceOf[ComponenteCompuesto], "auto", List("motor", "puerta", "puerta", "puerta", "puerta", "carroceria", "asiento", "asiento", "asiento", "asiento"), List("volante"))
    
    assertReservas(List())
    
    fabrica.reservar("auto")
    assertReservas(List("auto"))
    assertStock(List())
    auto = deposito.quitarReservados("auto")
    assertCompuesto(auto.asInstanceOf[ComponenteCompuesto], "auto", listaAuto, List())
    
  }
  
  @Test
  def testReservarAutoSinFabricar {
    fabrica.setTipoReserva(reservarSinFabricar)
    fabrica.reservar("auto")
    assertStock(List())
    assertReservas(List())
    
    deposito.agregarFabricados(factoryMateriaPrima.crear("vidrio", produccion))
    deposito.agregarFabricados(factoryMateriaPrima.crear("molde de aluminio", produccion))
    deposito.agregarFabricados(factoryMateriaPrima.crear("molde de aluminio", produccion))
    deposito.agregarFabricados(factoryMateriaPrima.crear("molde de zinc", produccion))
    deposito.agregarFabricados(factoryMateriaPrima.crear("molde de zinc", produccion))
    
    fabrica.reservar("chapa")
    assertStock(List("vidrio", "molde de aluminio", "molde de aluminio", "molde de zinc", "molde de zinc"))
    assertReservas(List())
    
    deposito.agregarFabricados(factoryMateriaPrima.crear("molde de tungsteno", produccion))
    fabrica.reservar("chapa")
    assertStock(List("vidrio"))
    assertReservas(List("chapa"))
    
  }
  
  
  
  
  /**************** AUXILIARES ****************/
  def assertCantidadReservados(msg:String, cant:Int) {
    assertEquals(msg, cant, deposito.reservados.size)
  }
  
  def assertCantidadFabricados(msg:String, cant:Int) {
    assertEquals(msg, cant, deposito.fabricados.size)
  }
  
  def assertComponente(comp:Componente, nombre:String) {
    comp.assertComponente(nombre)
  }
  
  def assertMateriaPrima(mPrima:MateriaPrima, nombre:String) {
     mPrima.assertComponente(nombre)
  }
  
  def assertCompuesto(compuesto:ComponenteCompuesto, nombre:String, listaFabricados:List[String], listaReservados:List[String]){
	compuesto.assertComponente(nombre)
    assertEquals("No tiene los mismos fabricados", listaFabricados.sorted, compuesto.componentesFabricados.map(_.nombre).sorted)
    assertEquals("No tiene los mismos fabricados", listaReservados.sorted, compuesto.componentesReservados.map(_.nombre).sorted)    
  }
  
  def assertStock(existencias:List[String]) {
    assertEquals("No hay lo mismo en el deposito", existencias.sorted, deposito.fabricados.map(_.nombre).sorted)
  }
  
  def assertReservas(existencias:List[String]) {
    assertEquals("No hay lo mismo en el deposito", existencias.sorted, deposito.reservados.map(_.nombre).sorted)
  }
  /********************************************/
  
}

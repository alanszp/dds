package com.utn.parte2y4

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit

import com.utn.comun.Deposito
import com.utn.comun.Producto


class test2y4 extends  AssertionsForJUnit {
  
  @Before
  var deposito = new Deposito
  
  var eventoSalidaCant = new EventoSalidaCant  
  this.agregarManejador(eventoSalidaCant)
  var eventoSalidaStockMinimo = new EventoSalidaStockMinimo
  this.agregarManejador(eventoSalidaStockMinimo)
  var eventoSuperarStockMinimo = new EventoSuperarStockMinimo
  this.agregarManejador(eventoSuperarStockMinimo)
  var eventoSuperarStockMaximo = new EventoSuperarStockMaximo
  this.agregarManejador(eventoSuperarStockMaximo)
  
  var prodSilla = new Producto("silla",3,10,4,true,4)
  this.agregarProductos(prodSilla, 6)
  
  var prodMesa = new Producto("mesa",2,6,3,false,3)
  this.agregarProductos(prodMesa, 3)
  
  var prodEscritorio = new Producto("escritorio",2,5,3,true,3)
  this.agregarProductos(prodSilla, 6)
  
  
  @Test
  def testRestarProducto {    
    var prodSilla = new Producto("silla")
    deposito.restarProducto(prodSilla)
    
    assertCantProductos(prodSilla)
  }
  
  
  /*******************AUXILIARES****************************************/
  
  def assertCantProductos(prod: Producto){
    assertEquals("no coincide la cantidad de productos", deposito.cuantosHay(prod), 5)
  }

  
  
  /******************FUNCIONES PRIVADAS******************************/
  def agregarManejador(m: ManejadorEventos){deposito.manejadores += m}
  
  def agregarProducto(p: Producto){deposito.productos += p}
  
  def agregarProductos(p: Producto, cant: Int){
    (1 to cant).foreach(_=> this.agregarProducto(p))
  }

  
  
  
  
  /*******************TEST 1 Y 3********************/
  /*
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
  */
}
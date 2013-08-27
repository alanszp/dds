package com.utn.parte2y4

import org.junit.Before
import org.scalatest.junit.AssertionsForJUnit

import com.utn.comun.Deposito

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
  

  
  
  /******************FUNCIONES PRIVADAS******************************/
  def agregarManejador(m: ManejadorEventos){deposito.manejadores += m}
  
  
  
  /*******************TEST 2 Y 4********************/
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
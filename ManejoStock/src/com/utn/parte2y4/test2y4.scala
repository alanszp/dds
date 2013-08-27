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
  var eventoSalidaStockMinimo = new EventoSalidaStockMinimo
  var eventoSuperarStockMinimo = new EventoSuperarStockMinimo  
  var eventoSuperarStockMaximo = new EventoSuperarStockMaximo  
  
  var prodSilla = new Producto("silla",3,10,4,true,4)  
  var prodMesa = new Producto("mesa",2,6,3,false,3)  
  var prodEscritorio = new Producto("escritorio",2,5,3,true,3) 
  
  @Test
  def PruebaTest{assertEquals(1,1)}
  
  @Test
  def testRestarProducto {    
    this.setup
    deposito.restarProducto(prodSilla)
    
    assertCantProductos(prodSilla)
  }
  
  
  /*******************AUXILIARES****************************************/
  
  def assertCantProductos(prod: Producto){
    assertEquals("no coincide la cantidad de productos", deposito.cuantosHay(prod), 5)
  }  
  
  /******************FUNCIONES PRIVADAS******************************/
  def setup(){
    this.agregarManejador(eventoSalidaCant)
    this.agregarManejador(eventoSalidaStockMinimo)
    this.agregarManejador(eventoSuperarStockMinimo)
    this.agregarManejador(eventoSuperarStockMaximo)
    this.agregarProductos(prodSilla, 6)
    this.agregarProductos(prodMesa, 3)
    this.agregarProductos(prodSilla, 6)    
  }
  
  def agregarManejador(m: ManejadorEventos){deposito.manejadores += m}
  
  def agregarProductos(p: Producto, cant: Int){
    (1 to cant).foreach(_=> deposito.productos += p)
  }
}
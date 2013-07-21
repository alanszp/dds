package com.utn.parte1y3

import org.scalatest.junit._
import org.junit.Assert._
import org.junit.Test
import org.junit.Before
import org.junit.After
import com.utn.comun._

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
  
  @Test
  def testSiCreaDepositoVacio {
    assertCantidadReservados("No hay 0 reservados", 0)
    assertCantidadFabricados("No habia 0 fabricados", 0)
  }
  
  @Test
  def testCreaMateriaPrima {
    var mPrima = factoryMateriaPrima.crear("caño", null)
    
    assertMateriaPrima(mPrima, "caño")
  }
  
  @Test
  def testCrearCompuesto {
    var compuesto = factoryChapa.crear("chapa", produccion)
    assertCompuesto(compuesto, "chapa", listaChapa, List())
  }
  
  def assertCantidadReservados(msg:String, cant:Int) {
    assertEquals(msg, cant, deposito.reservados.size)
  }
  
  def assertCantidadFabricados(msg:String, cant:Int) {
    assertEquals(msg, cant, deposito.fabricados.size)
  }
  
  def assertMateriaPrima(mPrima:Componente, nombre:String) {
    assertTrue("No es de clase materia prima", mPrima.isInstanceOf[MateriaPrima])
    assertEquals("No tienen el mismo nombre", nombre, mPrima.nombre)
  }
  
  def assertCompuesto(compuesto:ComponenteCompuesto, nombre:String, listaFabricados:List[String], listaReservados:List[String]){
	assertTrue("No es de clase componente compuesto", compuesto.isInstanceOf[ComponenteCompuesto])
    assertEquals("No tienen el mismo nombre", nombre, compuesto.nombre)
    assertEquals("No hay la misma cantidad de fabricados", listaReservados.size ,compuesto.componentesReservados.size)
    assertEquals("No hay la misma cantidad de fabricados", listaFabricados.size ,compuesto.componentesFabricados.size)
    
  }
  
}

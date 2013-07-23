package com.utn.comun

import org.scalatest.junit._
import org.junit.Assert._

class ComponenteCompuesto(val nombre:String) extends Componente {
  
  var componentesReservados: List[Componente] = List()
  var componentesFabricados: List[Componente] = List()
  
  def agregarReservado(componente:Componente) = componentesReservados = componentesReservados :+ componente 
  def agregarFabricado(componente:Componente) = componentesFabricados = componentesFabricados :+ componente 
  
  def assertClase {
    assertTrue("No es de clase componente compuesto", this.isInstanceOf[ComponenteCompuesto])
  }
}
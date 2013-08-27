package com.utn.comun

import org.scalatest.junit._
import org.junit.Assert._

class Producto(override val nombre:String, val cantMinima: Int,val cantMaxima : Int, val puntoDePedido : Int, val necesitaLog: Boolean, val cantCriticas: Int) extends ComponenteCompuesto(nombre) {
  
 def this(nombre: String){this(nombre,0,0,0,false,0)}
 
 
 override def assertClase {
    assertTrue("No es de clase producto", this.isInstanceOf[Producto])
  }

}
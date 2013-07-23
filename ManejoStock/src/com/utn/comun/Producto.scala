package com.utn.comun

import org.scalatest.junit._
import org.junit.Assert._

class Producto(override val nombre:String) extends ComponenteCompuesto(nombre) {
  
 override def assertClase {
    assertTrue("No es de clase producto", this.isInstanceOf[Producto])
  }

}
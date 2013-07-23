package com.utn.comun

import org.scalatest.junit._
import org.junit.Assert._

class MateriaPrima(val nombre:String) extends Componente {
  
 def assertClase {
    assertTrue("No es de clase materia prima", this.isInstanceOf[MateriaPrima])
  }
}
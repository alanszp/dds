package com.utn.comun

import org.scalatest.junit._
import org.junit.Assert._

abstract class Componente {
	val nombre:String
	
	def sos(str:String):Boolean = str == nombre
	
	def assertComponente(nombre:String) {
	  	this.assertClase
	  	assertEquals("No tienen el mismo nombre", nombre, this.nombre)
	}
	
	def assertClase
}
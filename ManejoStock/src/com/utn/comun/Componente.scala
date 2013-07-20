package com.utn.comun

abstract class Componente {
	var nombre:String
	
	def sos(str:String):Boolean = str == nombre
}
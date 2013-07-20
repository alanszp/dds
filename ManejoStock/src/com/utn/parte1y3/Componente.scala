package com.utn.parte1y3

abstract class Componente {
	var nombre:String
	
	def sos(str:String):Boolean = str == nombre
}
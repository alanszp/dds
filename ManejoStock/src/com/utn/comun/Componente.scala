package com.utn.comun

abstract class Componente {
	val nombre:String
	
	def sos(str:String):Boolean = str == nombre
}
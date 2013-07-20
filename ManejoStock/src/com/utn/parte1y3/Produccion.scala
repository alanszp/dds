package com.utn.parte1y3

import com.utn.comun.Componente

class Produccion {
	var dictionary:Map[String, FactoryComponente] = Map()
	var fabrica:Fabrica = null
	
	def asignarAFabrica(fabrica:Fabrica) = {
	  this.fabrica = fabrica
	}
	
	def crear(componente:String):Componente ={
	  factory = dictionary.get(componente)	
	  return factory.crear(componente, this)
	}
	
	
}
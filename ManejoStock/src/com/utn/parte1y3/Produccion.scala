package com.utn.parte1y3

import com.utn.comun._

class Produccion {
	var diccionario:Map[String, FactoryComponente] = Map()
	var fabrica:Fabrica = null
	
	def setFabrica(fabrica:Fabrica) = {this.fabrica = fabrica}
	
	def crear(componente:String):Componente ={
	  var factory:FactoryComponente = diccionario.get(componente).getOrElse(null)	
	  if (factory != null){
	    return factory.crear(componente, this)
	  }
	  return null
	}
	
	def setDiccionario(map:Map[String, FactoryComponente]) {
	  diccionario = map
	}
	
}
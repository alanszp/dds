package com.utn.parte1y3

import com.utn.comun._

class Produccion {
	var diccionario:Map[String, FactoryComponente] = Map() //Map con todos los productos y comp. compuestos. Lo que no esta es materia prima
	var fabrica:Fabrica = null
	
	def setFabrica(fabrica:Fabrica) = {this.fabrica = fabrica}
	
	def crear(componente:String):Componente ={
	  var factory = getFactory(componente)
	  return factory.crear(componente, this)
	}
	
	def crearSiHayStock(componente:String):Componente = {
	  if (chequearQueTieneTodo(componente))  
		return crear(componente)
		  
	  return null
	}
	
	def setDiccionario(map:Map[String, FactoryComponente]) {
	  diccionario = map
	}

	def chequearQueTieneTodo(componente:String):Boolean = {
	  var factory = getFactory(componente)
	  try {
	    factory.tenesParaFabricar(componente, this)
	    return true
	  }
	  catch {
	    case e: NoHayStockException => {
	      return false
	    }
	  }
	}
	
	def getFactory(componente:String):FactoryComponente = {
	  this.diccionario.get(componente).getOrElse(new FactoryMateriaPrima)  //Lo que no este en el map es materia prima
	}
	
}
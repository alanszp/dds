package com.utn.parte1y3

import com.utn.comun.ComponenteCompuesto

class FactoryCompuesto(var listaComponentes:List[String]) extends FactoryComponente {
	def crear(nombre:String, produccion:Produccion):ComponenteCompuesto = {
		var compuesto = nuevoComponente(nombre)
		rellenar(compuesto, produccion)
		return compuesto
	}

	def rellenar(compuesto:ComponenteCompuesto, produccion:Produccion) = {
		
		listaComponentes.foreach(this.agregar(compuesto, produccion,_))
	}
	
	def nuevoComponente(nombre:String):ComponenteCompuesto = {
		return new ComponenteCompuesto(nombre)
	}
	
	def agregar(compuesto:ComponenteCompuesto, produccion:Produccion, nombre:String) = {
	  val deposito = produccion.fabrica.deposito
	  if(deposito.hayFabricados(nombre)){
		compuesto.componentesReservados += deposito.quitarFabricados(nombre)		  
	  }
	  else {
	    compuesto.componentesFabricados += produccion.crear(nombre)
	  }
	}
}
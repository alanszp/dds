package com.utn.parte1y3

import com.utn.comun._

class FactoryCompuesto(listaComponetes:List[String]) extends FactoryComponente {
  
	def crear(nombre:String, produccion:Produccion):ComponenteCompuesto = {
		var compuesto = nuevoComponente(nombre)
		rellenar(compuesto, produccion)
		return compuesto
	}

	def rellenar(compuesto:ComponenteCompuesto, produccion:Produccion) = {
		listaComponetes.foreach(this.agregar(compuesto, produccion,_))
	}

	def agregar(compuesto:ComponenteCompuesto, produccion:Produccion, nombre: String) = {
	  val deposito = produccion.fabrica.deposito
	  if(deposito.hayFabricados(nombre)){
		compuesto.agregarReservado(deposito.quitarFabricados(nombre))		  
	  }
	  else {
	    compuesto agregarFabricado produccion.crear(nombre)
	  }
	}

	def nuevoComponente(nombre:String):ComponenteCompuesto = {
		return new ComponenteCompuesto(nombre)
	}
}
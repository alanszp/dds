package com.utn.parte1y3

import com.utn.comun.Componente
import com.utn.comun.Deposito

abstract class FactoryComponente {
	def crear(nombre:String, produccion:Produccion):Componente
	
	def tenesParaFabricar(nombre:String, produccion:Produccion) = {
	  if (!produccion.fabrica.deposito.hayFabricados(nombre))
	    throw new NoHayStockException
	}
}
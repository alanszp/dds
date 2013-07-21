package com.utn.parte1y3

import com.utn.comun.MateriaPrima

class FactoryMateriaPrima extends FactoryComponente {
	def crear(nombre:String, produccion:Produccion):MateriaPrima = {
	  return new MateriaPrima(nombre)
	}
}
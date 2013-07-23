package com.utn.parte1y3

import com.utn.comun.MateriaPrima
import com.utn.comun.Deposito
import sun.awt.image.BadDepthException

class FactoryMateriaPrima extends FactoryComponente {
	def crear(nombre:String, produccion:Produccion):MateriaPrima = {
	  return new MateriaPrima(nombre)
	}
}
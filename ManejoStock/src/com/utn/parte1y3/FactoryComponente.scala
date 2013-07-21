package com.utn.parte1y3

import com.utn.comun.Componente

abstract class FactoryComponente {
	def crear(nombre:String, produccion:Produccion):Componente;
}
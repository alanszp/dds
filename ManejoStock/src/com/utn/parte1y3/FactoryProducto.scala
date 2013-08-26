package com.utn.parte1y3

import com.utn.comun.Producto

class FactoryProducto (listaComponetes:List[String]) extends FactoryCompuesto(listaComponetes) {
	override def nuevoComponente(nombre:String):Producto = {
	  //ver aca
		return new Producto(nombre,0,0,0,false,0)
	}
}
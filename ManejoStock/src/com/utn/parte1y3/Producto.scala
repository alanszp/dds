package com.utn.parte1y3

class Producto (var nombre:String) extends ComponenteCompuesto {
	
	var componentesReservados: Set[Componente] = Set()
	var componentesFabricados: Set[Componente] = Set()
}
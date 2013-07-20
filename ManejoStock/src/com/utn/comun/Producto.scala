package com.utn.comun

import com.utn.comun.Componente
import com.utn.comun.ComponenteCompuesto

class Producto(var nombre:String) extends ComponenteCompuesto {
  
	var componentesReservados: List[Componente] = List()
	var componentesFabricados: List[Componente] = List()
}
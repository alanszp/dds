package com.utn.comun

import com.utn.comun.Componente

class ComponenteCompuesto(var nombre:String) extends Componente {

  var componentesReservados: List[Componente] = List()
  var componentesFabricados: List[Componente] = List()
  
}
package com.utn.parte1y3

class ComponenteCompuesto(var nombre:String) extends Componente {

  var componentesReservados: Set[Componente] = Set()
  var componentesFabricados: Set[Componente] = Set()
  
}
package com.utn.comun


class ComponenteCompuesto(val nombre:String) extends Componente {
  
  var componentesReservados: List[Componente] = List()
  var componentesFabricados: List[Componente] = List()
  
  def agregarReservado(componente:Componente) = componentesReservados = componentesReservados :+ componente 
  def agregarFabricado(componente:Componente) = componentesFabricados = componentesFabricados :+ componente 
}
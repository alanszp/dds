package com.utn.parte1y3

class Deposito {
  
   var fabricados:Set[Componente] = Set()
   var reservados:Set[Componente] = Set()


   def hayReservados(comp: String): Boolean = this.reservados.exists(_.sos(comp))
   def agregarReservados(comp: Componente) { this.reservados += comp }
   
   def hayFabricados(comp: String): Boolean = this.fabricados.exists(_.sos(comp))
   def getDeFabricados(comp: String): Componente = this.fabricados.find(_.sos(comp)).getOrElse(null)
   
   def quitarFabricados(comp: String): Componente = { 
     var componente = getDeFabricados(comp)
     if (componente != null){
       this.fabricados -= componente
     }
     return componente
   }
   
   def quitarFabricados(comp: Componente): Boolean = {
     var bool = hayFabricados(comp.nombre)
     if(bool){
       this.fabricados -= comp
     }
     return bool
   }
   
   def agregarFabricados(comp: Componente) { this.fabricados += comp }
   
}
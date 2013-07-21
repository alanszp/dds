package com.utn.comun

import com.utn.parte1y3.Fabrica


class Deposito {
  
   var fabricados:List[Componente] = List()
   var reservados:List[Componente] = List()
   var fabrica:Fabrica = null
   
   def setFabrica(fabrica:Fabrica) =  {this.fabrica = fabrica}
   
   
   /*****************METODOS PARA FABRICADOS Y RESERVADOS *************/
   def hayReservados(comp: String): Boolean = this.reservados.exists(_.sos(comp))
   def agregarReservados(comp: Componente) = reservados = reservados :+ comp
   
   def hayFabricados(comp: String): Boolean = this.fabricados.exists(_.sos(comp))
   def hayFabricados(comp: Componente): Boolean = this.fabricados.exists(_.equals(comp))
   
   def getDeFabricados(comp: String): Componente = this.fabricados.find(_.sos(comp)).getOrElse(null)
   
   def quitarFabricados(comp: String): Componente = { 
     var componente = getDeFabricados(comp)
     if (componente != null){
       fabricados = fabricados diff List(componente)
     }
     return componente
   }
   
   def quitarFabricados(comp: Componente): Boolean = {
     var bool = hayFabricados(comp.nombre)
     if(bool){
       fabricados = fabricados diff List(comp)
     }
     return bool
   }
   
   def agregarFabricados(comp: Componente) = fabricados = fabricados :+ comp
   /************************************************************************/
}
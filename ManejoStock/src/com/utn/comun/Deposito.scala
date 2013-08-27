package com.utn.comun

import com.utn.parte1y3.Fabrica
import com.utn.parte1y3.NoHayStockException
import com.utn.parte2y4.ManejadorEventos


class Deposito {
  
   var fabricados:List[Componente] = List()
   var reservados:List[Componente] = List()
   var productos:Set[Producto] = Set()
   var manejadores:Set[ManejadorEventos] = Set()
   var fabrica:Fabrica = null
   
   def setFabrica(fabrica:Fabrica) =  {this.fabrica = fabrica}
   
   
   /*****************METODOS PARA FABRICADOS Y RESERVADOS *************/
   def hayReservados(comp: String): Boolean = this.reservados.exists(_.sos(comp))
   def agregarReservados(comp: Componente) = reservados = reservados :+ comp
   def quitarReservados(comp: String): Componente = { 
     var componente = getDeReservados(comp)
     if (componente != null){
       reservados = reservados diff List(componente)
     }
     return componente
   }
   def getDeReservados(comp: String): Componente = this.reservados.find(_.sos(comp)).getOrElse(null)
   
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
   
   def cuantosHay(prod: Producto ): Int = this.productos.count(_ == productos)
   
   def sumarProducto(prod: Producto){this.productos += prod}
   def restarProducto(prod: Producto){this.productos-=prod}
   
   def sacarProducto(prod: Producto, cant: Int) { 
     (this.manejadores).foreach( (manejador) => manejador.manejar(prod, cuantosHay(prod), cant) )
     (1 to cant).foreach(_=> this.restarProducto(prod))       
   }   

   def agregarProducto(prod: Producto, cant: Int) { 
     (this.manejadores).foreach( (manejador) => manejador.manejar(prod, cuantosHay(prod), cant) )
     (1 to cant).foreach(_=> this.sumarProducto(prod))
   }
       
   /************************************************************************/
}
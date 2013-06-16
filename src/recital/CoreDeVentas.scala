package recital

class CoreDeVentas {

  var entradas: Set[Entrada] = Set()
  var noches: Set[Noche] = Set()
 
  def venderEntrada(Entrada: Entrada) {
    
   if (this.entradas.contains(Entrada)){
     
     //no vender
     
   } else{
     this.entradas += Entrada
   }
  }
  
  def vaciarListaEntradas = {
    entradas.empty
  }
  
}
class CoreDeVentas (Entrada: Entrada) {

  var entradas: Set[Entrada] = Set()
  
  def venderEntrada(Entrada: Entrada) {
    
   if (this.entradas.contains(Entrada)){
     
     //no vender
     
   } else{
     this.entradas += Entrada
   }
  }
}
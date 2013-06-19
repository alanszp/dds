package recital

class ComboEntrada (var porcentajeDescuento: Double) {
  
  var entradas: Set[Entrada] = Set()
  
  def precioAux =  entradas.map(_.precioEntrada).sum
  
  def precioEntrada : Double ={
      if(this.precioAux > 1000){
    	  return this.precioAux * porcentajeDescuento
      }
      	this.precioAux
  }
}
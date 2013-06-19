package recital

class Combo (porcentajeDescuento: Double) {
  
  var entradas: Set[Entrada] = Set()
  
  def precioAux =  entradas.map(_.precioEntrada).sum
  
  def precioEntrada ={
      if(this.precioAux > 1000){
    	  precioAux * porcentajeDescuento
      }
  }
}
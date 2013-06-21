package recital

class ComboEntrada (var porcentajeDescuento: Double) extends entradaAbstracta {
  
  var entradas: Set[Entrada] = Set()
  
  def precioEntrada : Double ={
      if(this.precioAux > 1000){
    	  return this.precioAux * porcentajeDescuento
      }
      	this.precioAux
  }
  
  def cantidadDeEntradas = this.entradas.size
		  
  def sosOLaTenes(e: entradaAbstracta):Boolean = {
	  e.isInstanceOf[Entrada] && this.tenesEntrada(e.asInstanceOf[Entrada]) ||
	  e.isInstanceOf[ComboEntrada] && this.tenesAlgunaEntrada(e.asInstanceOf[ComboEntrada])
  }

  def precioAux =  entradas.map(_.precioEntrada).sum
  
  def tenesEntrada(entrada:Entrada):Boolean = this.entradas.contains(entrada)
  
  def tenesAlgunaEntrada(otroCombo:ComboEntrada):Boolean = (this.entradas intersect otroCombo.entradas).size > 0
  
  def agregar(entrada:Entrada) = this.entradas += entrada
 }
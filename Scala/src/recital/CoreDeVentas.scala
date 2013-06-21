package recital

class CoreDeVentas {

  var entradas: Set[entradaAbstracta] = Set()
  var noches: Set[Noche] = Set()
 
  def venderEntrada(entrada: entradaAbstracta) {
	  try {
		  this.agregarEntrada(entrada);
	  }
	  catch {
	  case e: EntradaExistenteException => throw e //Informar al usuario que no pudo hacer nada!
	  }	
  }
  
  def existeEntrada(entrada : entradaAbstracta) : Boolean = this.entradas.exists(_ sosOLaTenes entrada)
		  
  def agregarEntrada(entrada : entradaAbstracta) {
   if (existeEntrada(entrada)){
	  throw new EntradaExistenteException
   }
   
   this.entradas += entrada         
  }
  
  def cantidadEntradasVendidas = this.entradas.toList.map(_.cantidadDeEntradas).sum
  
  def cantidadEntradasVendidas(funcion: entradaAbstracta => Boolean) = this.entradas.filter(funcion).toList.map(_.cantidadDeEntradas).sum
  
  
}
package recital

class CoreDeVentas {

  var entradas: Set[Entrada] = Set()
  var noches: Set[Noche] = Set()
 
  def venderEntrada(entrada: Entrada) {
	  try {
		  this.agregarEntrada(entrada);
	  }
	  catch {
	  case e: EntradaExistenteException => throw e //Informar al usuario que no pudo hacer nada!
	  }	
  }
  
  def existeEntrada(entrada : Entrada) : Boolean = this.entradas.contains(entrada)
		  
  def agregarEntrada(entrada : Entrada) {
   if (existeEntrada(entrada)){
	   this.entradas += entrada         
   } else{
     throw new EntradaExistenteException
   }
  }
  
}
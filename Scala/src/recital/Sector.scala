package recital

class Sector ( var nombre: String){

  var filas: Set[RangoFilas] = Set()
  
  def valorEntradaBase(numero: Int): Double ={
    val fila = buscarFila(numero)
    	
    fila.precio
  }
  
  def verificarUbicacion(fila:Int, asiento:Int) = {
    val filaEncontrada = buscarFila(fila)
    
    if( !(filaEncontrada.existeAsiento(asiento)) ){
      throw new AsientoIncorrectoException
    }
  }
  
  def buscarFila(numero: Int): RangoFilas = {
    var fila = filas.find{fila: RangoFilas => fila.tengoFila(numero)}
    
    if (fila.isEmpty) 
    	throw new FilaIncorrectaException      
    	
    fila.get
  }
  
 
}
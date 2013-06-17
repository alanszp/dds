package recital

class Sector ( var nombre: String){

  var filas: Set[RangoFilas] = Set()
  
  def valorEntradaBase(numero: Int): Double ={
    var fila = filas.find{fila: RangoFilas => fila.tengoFila(numero)}
    
    if (fila.isEmpty) 
    	throw new FilaIncorrectaException      
    	
    fila.get.precio
    
  }
}
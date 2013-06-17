package recital

class RangoFilas(var desde: Int, var hasta: Int, var precio: Double, var cantAsientos:Int) {

  
  def tengoFila(fila: Int): Boolean ={
    (this.desde <= fila) && (this.hasta >= fila)
  }
  
}
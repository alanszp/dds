class RangoFilas(Desde: Int, Hasta: Int,Precio: Double, CantAsientos:Int) {
  
  var desde: Int = Desde
  var hasta: Int = Hasta 
  var precio: Double = Precio
  var cantAsientos: Int = CantAsientos

  def tengoFilas(fila: Int ): Boolean ={
    
    (this.desde >= fila) && (this.hasta <= fila)
  }
  
}
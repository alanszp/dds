package recital

class RangoFilas {
  
  def this(desde: Int, hasta: Int, precio: Double, cantAsientos:Int) = {
    this()
    this.desde = desde
    this.hasta = hasta
    this.precio = precio
    this.cantAsientos = cantAsientos
  }  
  
  var desde: Int =_
  var hasta: Int =_
  var precio: Double = _
  var cantAsientos:Int = _

  
  def tengoFila(fila: Int): Boolean = (this.desde <= fila) && (this.hasta >= fila)
   
  def existeAsiento(asiento: Int):Boolean = asiento <= this.cantAsientos && asiento > 0
}
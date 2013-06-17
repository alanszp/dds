package recital

class Sector ( var nombre: String, var precio: Double){

  var filas: Set[RangoFilas] = Set()
  
  def valorEntradaBase(numero: Int): Double ={
    val fila = filas.find{fila => fila.tengoFilas(numero)}
    
    fila.get.precio + this.precio
  }
}
package recital

class Sector (Nombre: String, Precio: Double){
  
  var nombre: String = Nombre
  var precio: Double = Precio
  var filas: Set[RangoFilas] = Set()
  
  def valorEntradaBase(): Double ={
    this.precio + filas.precio
  }

}
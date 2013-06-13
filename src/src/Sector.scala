class Sector (Nombre: String, Precio: Double, Filas:RangoFilas){
  
  var nombre: String = Nombre
  var precio: Double = Precio
  var filas: RangoFilas = Filas
  
  def valorEntradaBase(): Double ={
    this.precio + filas.precio
  }

}
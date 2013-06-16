package recital

class Entrada (Sector: Sector, Noche: Noche, Categoria:CategoriaPersona, Asiento:Int) {

  var sector: Sector = Sector
  var noche: Noche = Noche
  var categoria: CategoriaPersona = Categoria
  var asiento: Int = Asiento
  
  def precioEntrada(): Double =
    this.sector.precio + this.categoria.aplicarDescuento(this.sector.precio) + this.noche.valorExtra
  
}
package recital

class Entrada (var sector: Sector, var noche: Noche, var categoria:CategoriaPersona, var asiento:Int) {

  def precioEntrada(): Double =
   ( this.sector.precio + this.categoria.aplicarDescuento(this.sector.precio) + this.noche.valorExtra())
  
}
package recital

class Entrada (var sector: Sector, var noche: Noche, var categoria:CategoriaPersona, var fila: Int, var asiento:Int) {

  def valorEntradaBase = this.sector.valorEntradaBase(fila)
  def descuentoCategoria = this.categoria.aplicarDescuento(this.valorEntradaBase)
  def valorExtraPorNoche = this.noche.valorExtra
  
  def precioEntrada =  this.valorEntradaBase + this.valorExtraPorNoche - this.descuentoCategoria 
  
  def esDama = this.categoria.isInstanceOf[Damas]
  
  
}
package recital

class Entrada (var sector: Sector, var noche: Noche, var categoria:CategoriaPersona, var fila: Int, var asiento:Int) extends entradaAbstracta {

  sector.verificarUbicacion(fila, asiento) //Corre al inicializarse. Si no existen, tira excepcion por fila o por asiento inexistente...
  
  def precioEntrada =  this.valorEntradaBase + this.valorExtraPorNoche - this.descuentoCategoria 
  
  def cantidadDeEntradas = 1
  
  def sosOLaTenes(e: entradaAbstracta):Boolean = {
	  e.isInstanceOf[Entrada] && e.asInstanceOf[Entrada]==this ||
	  e.isInstanceOf[ComboEntrada] && e.asInstanceOf[ComboEntrada].tenesEntrada(this)
  }
  
  def valorEntradaBase = this.sector.valorEntradaBase(fila)
  def descuentoCategoria = this.categoria.aplicarDescuento(this.valorEntradaBase)
  def valorExtraPorNoche = this.noche.valorExtra
  
  def esDama:Boolean = this.categoria.isInstanceOf[Damas]
}
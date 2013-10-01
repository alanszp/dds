package recital

class Entrada extends EntradaAbstracta {

  def this(sector: Sector, noche: Noche, categoria:CategoriaPersona, fila: Int, asiento:Int) = {
    this()
    this.sector= sector
    this.noche = noche
    this.categoria = categoria
    this.fila = fila
    this.asiento = asiento
    
    this.validarEntrada //Corre al instanciarse con todos los parametros. 
  }
  
  var sector: Sector = _
  var noche: Noche = _
  var categoria:CategoriaPersona = _
  var fila: Int = _
  var asiento:Int = _
  
  def precioEntrada =  this.valorEntradaBase + this.valorExtraPorNoche - this.descuentoCategoria 
  
  def cantidadDeEntradas = 1
  
  def sosOLaTenes(e: EntradaAbstracta):Boolean = {
	  e.isInstanceOf[Entrada] && e.asInstanceOf[Entrada]==this ||
	  e.isInstanceOf[ComboEntrada] && e.asInstanceOf[ComboEntrada].tenesEntrada(this)
  }
  
  def valorEntradaBase = this.sector.valorEntradaBase(fila)
  def descuentoCategoria = this.categoria.aplicarDescuento(this.valorEntradaBase)
  def valorExtraPorNoche = this.noche.valorExtra
  
  def esDama:Boolean = this.categoria.isInstanceOf[Damas]
  
  def validarEntrada = {
     sector.verificarUbicacion(fila, asiento) //Si no existen, tira excepcion por fila o por asiento inexistente...
     noche.tieneDescuento(categoria) //Si no tiene descuento, tira excepcion por categoria no valida...
  }
}
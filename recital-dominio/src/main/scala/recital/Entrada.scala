package recital

import org.uqbar.commons.utils.Observable

@Observable
class Entrada extends EntradaAbstracta {

  def this(sector: Sector, noche: Noche, categoria:CategoriaPersona, fila: Int, asiento:Int, cliente:String, puestoVenta:String) = {
    this()
    this.sector= sector
    this.noche = noche
    this.categoria = categoria
    this.fila = fila
    this.asiento = asiento
    this.cliente = cliente
    this.puestoVenta = puestoVenta
    
    
    this.validarEntrada //Corre al instanciarse con todos los parametros. 
  }
  
  var sector: Sector = _
  var noche: Noche = _
  var categoria:CategoriaPersona = _
  var fila: Int = _
  var asiento:Int = _
  var cliente:String = _
  var puestoVenta:String =_
  
  def precioEntrada =  this.valorEntradaBase + this.valorExtraPorNoche - this.descuentoCategoria 
  
  def cantidadDeEntradas = 1
  
  def sosOLaTenes(e: EntradaAbstracta):Boolean = {
	  e.isInstanceOf[Entrada] && e.asInstanceOf[Entrada].sosIgual(this) ||
	  e.isInstanceOf[ComboEntrada] && e.asInstanceOf[ComboEntrada].tenesEntrada(this)
  }
  
  def sosIgual(e: Entrada) = {
    this.sector == e.sector &&
    this.asiento == e.asiento &&
    this.fila == e.fila &&
    this.noche == e.noche
  } 
  
  def valorEntradaBase = this.sector.valorEntradaBase(fila)
  def descuentoCategoria = this.categoria.aplicarDescuento(this.valorEntradaBase)
  def valorExtraPorNoche = this.noche.valorExtra
  
  def esDama:Boolean = this.categoria.isInstanceOf[Damas]
  
  def validarEntrada = {
     sector.verificarUbicacion(fila, asiento) //Si no existen, tira excepcion por fila o por asiento inexistente...
     noche.tieneDescuento(categoria) //Si no tiene descuento, tira excepcion por categoria no valida...
  }
  
  def entradas = Set(this)
}
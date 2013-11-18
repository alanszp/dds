package recital

import org.uqbar.commons.model.Entity

import uqbar.arena.persistence.annotations.Relation
import uqbar.arena.persistence.annotations.PersistentClass
import uqbar.arena.persistence.annotations.PersistentField

@PersistentClass
class Entrada extends EntradaAbstracta {

  def this(sector: Sector, noche: Noche, categoria:CategoriaPersona, fila: Int, asiento:Int, cliente:String, puestoVenta:String) = {
    this()
    this._sector= sector
    this._noche = noche
    this._categoria = categoria
    this._fila = fila
    this._asiento = asiento
    this._cliente = cliente
    this._puestoVenta = puestoVenta
    
    
    this.validarEntrada //Corre al instanciarse con todos los parametros. 
  }
  
  var _sector: Sector = _
  var _noche: Noche = _
  var _categoria:CategoriaPersona = _
  var _fila: Int = _
  var _asiento:Int = _
  var _cliente:String = _
  var _puestoVenta:String =_
  
    def puestoVenta(a:String) = _puestoVenta = a
  	@PersistentField
  	def puestoVenta = _puestoVenta

	def noche(na:Noche) = _noche = na  
  	@Relation
	def noche = _noche

	def categoriaPersona(c:CategoriaPersona) = _categoria = c	
	@Relation
	def categoriaPersona = _categoria

    def fila(f:Int) = _fila = f
	@PersistentField
  	def fila = _fila

  	
  	def asiento(as:Int) = _asiento = as  
  	@PersistentField
  	def asiento = _asiento

  	def sector(s:Sector) = _sector = s
  	@Relation
	def sector = _sector

  	def cliente(c:String) = _cliente = c	
	@PersistentField
  	def cliente = _cliente
  	
  	
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
  def descuentoCategoria = this._categoria.aplicarDescuento(this.valorEntradaBase)
  def valorExtraPorNoche = this._noche.valorExtra
  
  def esDama:Boolean = this._categoria.isInstanceOf[Damas]
  
  def validarEntrada = {
     sector.verificarUbicacion(fila, asiento) //Si no existen, tira excepcion por fila o por asiento inexistente...
     noche.tieneDescuento(_categoria) //Si no tiene descuento, tira excepcion por categoria no valida...
  }
  
  def entradas = Set(this)
}
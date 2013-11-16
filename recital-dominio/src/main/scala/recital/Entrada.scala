package recital

import org.uqbar.commons.model.Entity

import uqbar.arena.persistence.annotations.Relation
import uqbar.arena.persistence.annotations.PersistentClass
import uqbar.arena.persistence.annotations.PersistentField

@PersistentClass
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
  
  	@PersistentField
  	def getPuestoVenta = puestoVenta
  	def setPuestoVenta(a:String) = puestoVenta = a
  
  	@Relation
	def getNoche = noche
	def setNoche(na:Noche) = noche = na
	
	@Relation
	def geCategoriaPersona = categoria
	def setCategoriaPersona(c:CategoriaPersona) = categoria = c
  
	@PersistentField
  	def getFila = fila
  	def setFila(f:Int) = fila = f
  
  	@PersistentField
  	def getAsiento = asiento
  	def setAsiento(as:Int) = asiento = as
  	
  	@Relation
	def getSector = sector
	def setSector(s:Sector) = sector = s
	
	@PersistentField
  	def getCliente = cliente
  	def setCliente(c:String) = cliente = c
  	
  	
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
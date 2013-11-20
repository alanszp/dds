package recital

import uqbar.arena.persistence.annotations.PersistentField
import uqbar.arena.persistence.annotations.PersistentClass
import compatibility.DomainEntity


@PersistentClass
class RangoFilas extends DomainEntity {
  
  def this(desde: Int, hasta: Int, precio: Double, cantAsientos:Int) = {
    this()
    this.desde = desde
    this.hasta = hasta
    this.precio = precio
    this.cantAsientos = cantAsientos
  }  
  
  var desde: Int =_
  var hasta: Int =_
  var precio: Double = _
  var cantAsientos:Int = _

  
  def tengoFila(fila: Int): Boolean = (this.desde <= fila) && (this.hasta >= fila)
   
  def existeAsiento(asiento: Int):Boolean = asiento <= this.cantAsientos && asiento > 0
  
  	def setPrecio(n:Double) = precio = n
  	@PersistentField def getPrecio = precio
	
	def setDesde(n:Int) = desde = n
	@PersistentField def getDesde = desde

	def setHasta(n:Int) = hasta = n
	@PersistentField def getHasta = hasta

	def setCantAsientos(n:Int) = cantAsientos = n
	@PersistentField def getCantAsientos = cantAsientos

}
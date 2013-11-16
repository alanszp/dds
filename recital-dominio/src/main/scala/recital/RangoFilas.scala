package recital

import uqbar.arena.persistence.annotations.PersistentField

class RangoFilas extends Serializable {
  
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
  
  	@PersistentField
	def getprecio = precio
	def setprecio(n:Double) = precio = n
	
	@PersistentField
	def getdesde = desde
	def setdesde(n:Int) = desde = n
	
	@PersistentField
	def gethasta = hasta
	def sethasta(n:Int) = hasta = n
	
	@PersistentField
	def getcantAsientos = cantAsientos
	def setcantAsientos(n:Int) = cantAsientos = n
}
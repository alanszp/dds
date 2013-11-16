package recital

import uqbar.arena.persistence.annotations.PersistentField

class Menor12 extends CategoriaPersona {
  
  def this(porcentajeDescuento: Double) = {
    this()
    this.porcentajeDescuento = porcentajeDescuento
  }
  
  var porcentajeDescuento: Double =_ 
  val descripcion = "Menor12"

  override def aplicarDescuento(EntradaBase: Double):Double = {
    
    (EntradaBase * this.porcentajeDescuento)
  }
  
  	@PersistentField
	def getporcentajeDescuento = porcentajeDescuento
	def setporcentajeDescuento(n:Double) = porcentajeDescuento = n
}
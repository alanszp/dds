package recital

import uqbar.arena.persistence.annotations.PersistentField

class Menor extends CategoriaPersona {
	
  def this(precioDescuento: Double, porcentajeDescuento: Double) ={
    this()
    this.precioDescuento = precioDescuento
    this.porcentajeDescuento = porcentajeDescuento
  }
  
  var precioDescuento: Double = _
  var porcentajeDescuento: Double = _
  val descripcion = "Menor"
  
  override def aplicarDescuento(EntradaBase: Double):Double = {
		var descuento:Double = 0
	    if (EntradaBase > 100){
	      descuento = (EntradaBase * this.porcentajeDescuento)
	      
	    }else if((EntradaBase > 50) && (EntradaBase <= 100)){
	      descuento = this.precioDescuento
	      
	    }
	    
    	((descuento*100).round) / 100.0
	}
  
    @PersistentField
	def getprecioDescuento = precioDescuento
	def setprecioDescuento(n:Double) = precioDescuento = n
	
	@PersistentField
	def getporcentajeDescuento = porcentajeDescuento
	def setporcentajeDescuento(n:Double) = porcentajeDescuento = n
}
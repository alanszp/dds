package recital

import uqbar.arena.persistence.annotations.PersistentField
import uqbar.arena.persistence.annotations.PersistentClass

@PersistentClass
class Menor extends CategoriaPersona {
	
  def this(precioDescuento: Double, porcentajeDescuento: Double) ={
    this()
    this._precioDescuento = precioDescuento
    this._porcentajeDescuento = porcentajeDescuento
  }
  
  var _precioDescuento: Double = _
  var _porcentajeDescuento: Double = _
  val _descripcion = "Menor"
  
  override def aplicarDescuento(EntradaBase: Double):Double = {
		var descuento:Double = 0
	    if (EntradaBase > 100){
	      descuento = (EntradaBase * this._porcentajeDescuento)
	      
	    }else if((EntradaBase > 50) && (EntradaBase <= 100)){
	      descuento = this._precioDescuento
	      
	    }
	    
    	((descuento*100).round) / 100.0
	}
  
  	def precioDescuento(n:Double) = _precioDescuento = n
    @PersistentField
	def precioDescuento = _precioDescuento

	def porcentajeDescuento(n:Double) = _porcentajeDescuento = n
	@PersistentField
	def porcentajeDescuento = _porcentajeDescuento
	
	@PersistentField
	def descripcion = _descripcion

}
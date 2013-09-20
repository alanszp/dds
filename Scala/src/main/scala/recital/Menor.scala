package recital

class Menor extends CategoriaPersona {
	
  def this(precioDescuento: Double, porcentajeDescuento: Double) ={
    this()
    this.precioDescuento = precioDescuento
    this.porcentajeDescuento = porcentajeDescuento
  }
  
  var precioDescuento: Double = _
  var porcentajeDescuento: Double = _
  
  override def aplicarDescuento(EntradaBase: Double):Double = {
		var descuento:Double = 0
	    if (EntradaBase > 100){
	      descuento = (EntradaBase * this.porcentajeDescuento)
	      
	    }else if((EntradaBase > 50) && (EntradaBase <= 100)){
	      descuento = this.precioDescuento
	      
	    }
	    
    	((descuento*100).round) / 100.0
	}
}
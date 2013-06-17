package recital

class Menor (precioDescuento: Double, porcentajeDescuento: Double) extends CategoriaPersona {

  
  override def aplicarDescuento(EntradaBase: Double):Double = {
    
    if (EntradaBase > 100){
      return (EntradaBase * this.porcentajeDescuento)
    }else if((EntradaBase > 50) && (EntradaBase <= 100)){
      return (EntradaBase - this.precioDescuento)
    }else{
    return (EntradaBase)
    }
    
	}
}
class Menor (PrecioDescuento: Double, PorcentajeDescuento: Double) extends CategoriaPersona {

  var precioDescuento: Double = PrecioDescuento
  var porcentajeDescuento: Double = PorcentajeDescuento
  
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
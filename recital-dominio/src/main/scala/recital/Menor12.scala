package recital

class Menor12 extends CategoriaPersona {
  
  def this(porcentajeDescuento: Double) = {
    this()
    this.porcentajeDescuento = porcentajeDescuento
  }
  
  var porcentajeDescuento: Double =_ 

  override def aplicarDescuento(EntradaBase: Double):Double = {
    
    (EntradaBase * this.porcentajeDescuento)
  }
}
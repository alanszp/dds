package recital

class Menor12 (var porcentajeDescuento: Double) extends CategoriaPersona {

  override def aplicarDescuento(EntradaBase: Double):Double = {
    
    (EntradaBase * this.porcentajeDescuento)
  }
}
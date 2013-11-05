package recital

class Damas extends CategoriaPersona {

  def this(porcentajeDescuento: Double) = {
    this()
    this.porcentajeDescuento = porcentajeDescuento
  }
  
  var porcentajeDescuento: Double = _
    val descripcion = "Dama"
  override def aplicarDescuento(EntradaBase: Double):Double = {
    EntradaBase * this.porcentajeDescuento
  }
}
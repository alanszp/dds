package recital

class Jubilado extends CategoriaPersona{
  def this(precioDescuento: Double) = {
    this()
    this.precioDescuento = precioDescuento
  }
  
  var precioDescuento: Double = _
  val descripcion = "Jubilado"

  override def aplicarDescuento(EntradaBase: Double):Double = {
	return (EntradaBase * this.precioDescuento * 100).round / 100.0
  }
}
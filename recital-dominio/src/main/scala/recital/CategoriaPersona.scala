package recital

abstract class CategoriaPersona extends Serializable {
  val descripcion :String
  def aplicarDescuento(EntradaBase: Double):Double
}
package recital

import org.uqbar.commons.model.Entity

abstract class CategoriaPersona extends Entity {
  val descripcion :String
  def aplicarDescuento(EntradaBase: Double):Double
}
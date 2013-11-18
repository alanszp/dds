package recital

import org.uqbar.commons.model.Entity
import compatibility.DomainEntity

abstract class CategoriaPersona extends DomainEntity {
  val descripcion :String
  def aplicarDescuento(EntradaBase: Double):Double
}
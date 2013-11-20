package recital

import org.uqbar.commons.model.Entity
import compatibility.DomainEntity
import uqbar.arena.persistence.annotations.PersistentClass


abstract class CategoriaPersona extends DomainEntity {
  val _descripcion :String
  def aplicarDescuento(EntradaBase: Double):Double
}
package recital

import org.uqbar.commons.model.Entity
import compatibility.DomainEntity
import uqbar.arena.persistence.annotations.PersistentClass

@PersistentClass
abstract class CategoriaPersona extends DomainEntity {
  val descripcion :String
  def aplicarDescuento(EntradaBase: Double):Double
  
  override def toString : String = descripcion.toString()
}
package recital

import uqbar.arena.persistence.annotations.PersistentField
import uqbar.arena.persistence.annotations.PersistentClass

@PersistentClass
class Jubilado extends CategoriaPersona {
  def this(precioDescuento: Double) = {
    this()
    this._precioDescuento = precioDescuento
  }

  var _precioDescuento: Double = _
  val _descripcion = "Jubilado"

  override def aplicarDescuento(EntradaBase: Double): Double = {
    return (EntradaBase * this._precioDescuento * 100).round / 100.0
  }

  def precioDescuento(n: Double) = _precioDescuento = n
  @PersistentField
  def precioDescuento = _precioDescuento

  @PersistentField
  def descripcion = _descripcion
}
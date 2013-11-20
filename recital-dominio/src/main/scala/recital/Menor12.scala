package recital

import uqbar.arena.persistence.annotations.PersistentField
import uqbar.arena.persistence.annotations.PersistentClass

@PersistentClass
class Menor12 extends CategoriaPersona {

  def this(porcentajeDescuento: Double) = {
    this()
    this._porcentajeDescuento = porcentajeDescuento
  }

  var _porcentajeDescuento: Double = _
  val _descripcion = "Menor12"

  override def aplicarDescuento(EntradaBase: Double): Double = {

    (EntradaBase * this._porcentajeDescuento)
  }

  def porcentajeDescuento(n: Double) = _porcentajeDescuento = n
  @PersistentField
  def porcentajeDescuento = _porcentajeDescuento

  @PersistentField
  def descripcion = _descripcion
}
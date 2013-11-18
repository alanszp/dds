package recital

import uqbar.arena.persistence.annotations.PersistentField
import uqbar.arena.persistence.annotations.PersistentClass

@PersistentClass
class Jubilado extends CategoriaPersona {
  def this(precioDescuento: Double) = {
    this()
    this.precioDescuento = precioDescuento
  }

  var precioDescuento: Double = _
  val descripcion = "Jubilado"

  override def aplicarDescuento(EntradaBase: Double): Double = {
    return (EntradaBase * this.precioDescuento * 100).round / 100.0
  }

  def setPrecioDescuento(n: Double) = precioDescuento = n
  @PersistentField
  def getPrecioDescuento = precioDescuento

  @PersistentField
  def getDescripcion = descripcion
}
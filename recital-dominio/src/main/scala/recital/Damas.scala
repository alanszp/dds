package recital

import uqbar.arena.persistence.annotations.PersistentField
import uqbar.arena.persistence.annotations.PersistentClass

@PersistentClass
class Damas extends CategoriaPersona {

  def this(porcentajeDescuento: Double) = {
    this()
    this.porcentajeDescuento = porcentajeDescuento
  }

  var porcentajeDescuento: Double = _
  val descripcion = "Dama"
  override def aplicarDescuento(EntradaBase: Double): Double = {
    EntradaBase * this.porcentajeDescuento
  }

  def setPorcentajeDescuento(n: Double) = porcentajeDescuento = n
  @PersistentField
  def getPorcentajeDescuento = porcentajeDescuento

  @PersistentField
  def getDescripcion = descripcion
}


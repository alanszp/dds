package recital

import uqbar.arena.persistence.annotations.PersistentField
import uqbar.arena.persistence.annotations.PersistentClass
import compatibility.DomainEntity

@PersistentClass
class RangoFilas extends DomainEntity {

  def this(desde: Int, hasta: Int, precio: Double, cantAsientos: Int) = {
    this()
    this._desde = desde
    this._hasta = hasta
    this._precio = precio
    this._cantAsientos = cantAsientos
  }

  var _desde: Int = _
  var _hasta: Int = _
  var _precio: Double = _
  var _cantAsientos: Int = _

  def tengoFila(fila: Int): Boolean = (this._desde <= fila) && (this._hasta >= fila)

  def existeAsiento(asiento: Int): Boolean = asiento <= this._cantAsientos && asiento > 0

  def precio(n: Double) = _precio = n
  @PersistentField
  def precio = _precio

  def desde(n: Int) = _desde = n
  @PersistentField
  def desde = _desde

  def hasta(n: Int) = _hasta = n
  @PersistentField
  def hasta = _hasta

  def cantAsientos(n: Int) = _cantAsientos = n
  @PersistentField
  def cantAsientos = _cantAsientos

}
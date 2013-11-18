package recital

import uqbar.arena.persistence.annotations.PersistentField
import uqbar.arena.persistence.annotations.Relation
import uqbar.arena.persistence.annotations.PersistentClass
import compatibility.DomainEntity

@PersistentClass
class Sector extends DomainEntity {

  def this(nombre: String) = {
    this()
    this._nombre = nombre
  }

  var _nombre: String = _
  var _filas: Set[RangoFilas] = Set()

  def nombre(n: String) = _nombre = n
  @PersistentField
  def nombre = _nombre

  def filas(f: java.util.List[RangoFilas]) = _filas = listToSet(f)
  @Relation
  def filas: java.util.List[RangoFilas] = setToList(_filas)

  def valorEntradaBase(numero: Int): Double = {
    val fila = buscarFila(numero)

    fila.precio
  }

  def verificarUbicacion(fila: Int, asiento: Int) = {
    val filaEncontrada = buscarFila(fila)

    if (!(filaEncontrada.existeAsiento(asiento))) {
      throw new AsientoIncorrectoException
    }
  }

  def buscarFila(numero: Int): RangoFilas = {
    var fila = _filas.find { fila: RangoFilas => fila.tengoFila(numero) }

    if (fila.isEmpty)
      throw new FilaIncorrectaException

    fila.get
  }

}
package recital

import compatibility.DomainEntity
import uqbar.arena.persistence.annotations.PersistentClass
import uqbar.arena.persistence.annotations.PersistentField
import uqbar.arena.persistence.annotations.Relation

@PersistentClass
class Noche extends DomainEntity {

  def this(fecha: String) = {
    this()
    this._fecha = fecha
  }

  var _nombreNoche: String = _
  var _fecha: String = _
  var _bandas: Set[Banda] = Set()
  var _descuentos: Set[CategoriaPersona] = Set()
  var _sectores: Set[Sector] = Set()

  def esIgual(noche: Noche) = {
    this._fecha == noche.fecha &&
    this._nombreNoche.equalsIgnoreCase(noche.nombreNoche) 
  }

  def nombreNoche(n: String) = _nombreNoche = n
  @PersistentField
  def nombreNoche = _nombreNoche
  
  def fecha(f: String) = _fecha = f
  @PersistentField
  def fecha = _fecha
 

  def bandas(b: java.util.List[Banda]) = _bandas = listToSet(b)
  @Relation
  def bandas: java.util.List[Banda] = setToList(_bandas)

  def descuentos(d: java.util.List[CategoriaPersona]) = _descuentos = listToSet(d)
  @Relation
  def descuentos: java.util.List[CategoriaPersona] = setToList(_descuentos)

  def sectores(s: java.util.List[Sector]) = _sectores = listToSet(s)
  @Relation
  def sectores: java.util.List[Sector] = setToList(_sectores)

  def valorExtra: Double = this._bandas.maxBy(x => x.precioCategoria).precioCategoria

  def tieneDescuento(categoriaPersona: CategoriaPersona) = {
    if (!this.descuentos.contains(categoriaPersona)) {
      throw new CategoriaNoValidaException
    }
  }

}
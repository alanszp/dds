package recital

import compatibility.DomainEntity
import uqbar.arena.persistence.annotations.PersistentClass
import uqbar.arena.persistence.annotations.PersistentField
import uqbar.arena.persistence.annotations.Relation

@PersistentClass
class Noche extends DomainEntity {

  def this(fecha: String) = {
    this()
    this.fecha = fecha
  }

  var nombreNoche: String = _
  var fecha: String = _
  var bandas: Set[Banda] = Set()
  var descuentos: Set[CategoriaPersona] = Set()
  var sectores: Set[Sector] = Set()

  def esIgual(noche: Noche) : Boolean = {
    if(this.fecha == null || noche.fecha == null)
      return false
    this.fecha.equals(noche.fecha)
  }

  def setNombreNoche(n: String) = nombreNoche = n
  @PersistentField def getNombreNoche = nombreNoche
  
  def setFecha(f: String) = fecha = f
  @PersistentField def getFecha = fecha
 

  def setBandas(b: java.util.List[Banda]) = bandas = listToSet(b)
  @Relation def getBandas: java.util.List[Banda] = setToList(bandas)

  def setDescuentos(d: java.util.List[CategoriaPersona]) = descuentos = listToSet(d)
  @Relation def getDescuentos: java.util.List[CategoriaPersona] = setToList(descuentos)

  def setSectores(s: java.util.List[Sector]) = sectores = listToSet(s)
  @Relation def getSectores: java.util.List[Sector] = setToList(sectores)

  def valorExtra: Double = this.bandas.maxBy(x => x.precioCategoria).precioCategoria

  def tieneDescuento(categoriaPersona: CategoriaPersona) = {
    if (!this.descuentos.contains(categoriaPersona)) {
      throw new CategoriaNoValidaException
    }
  }
  
  override def toString : String = fecha.toString()

}
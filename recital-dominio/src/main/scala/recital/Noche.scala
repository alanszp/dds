package recital

import compatibility.DomainEntity
import uqbar.arena.persistence.annotations.PersistentClass
import uqbar.arena.persistence.annotations.PersistentField
import uqbar.arena.persistence.annotations.Relation

@PersistentClass
class Noche extends DomainEntity  { 
	
	def this(fecha: String) = {
	  this()
	  this.fecha = fecha
	}

	var nombreNoche: String = _
	var fecha: String = _
	var bandas: Set[Banda] = Set()
	var descuentos: Set[CategoriaPersona] = Set()
	var sectores : Set[Sector] = Set()
	
	@PersistentField
	def getNombreNoche = nombreNoche
	def setNombreNoche(n:String) = nombreNoche = n
	
	@PersistentField
	def getFecha = fecha
	def setFecha(f:String) = fecha = f
	
	@Relation
	def getBandas : Set[Banda] = bandas
	def setBandas(b:Set[Banda]) = bandas = b
	
	@Relation
	def getDescuentos : Set[CategoriaPersona] = descuentos
	def setDescuentos(d:Set[CategoriaPersona]) = descuentos = d
	
	@Relation
	def getSectores : Set[Sector] = sectores
	def setSectores(s:Set[Sector]) = sectores = s
	
	def valorExtra : Double = this.bandas.maxBy(x => x.precioCategoria).precioCategoria
	
	def tieneDescuento(categoriaPersona : CategoriaPersona) = {
	  if (!this.descuentos.contains(categoriaPersona)) {
	    throw new CategoriaNoValidaException
	  }
	}

}
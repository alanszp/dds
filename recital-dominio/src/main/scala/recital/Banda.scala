package recital

import uqbar.arena.persistence.annotations.PersistentClass
import org.uqbar.commons.model.Entity
import uqbar.arena.persistence.annotations.PersistentField
import uqbar.arena.persistence.annotations.Relation
import compatibility.DomainEntity

@PersistentClass
class Banda extends DomainEntity {
	def this(nom:String, cat:CategoriaBanda) = {
	  this()
	  this.nombre = nom
	  this.categoria = cat
	}
  
	var nombre:String = _
	var categoria:CategoriaBanda = _
	
	@PersistentField
	def getNombre = nombre
	def setNombre(n:String) = nombre = n
	
	@Relation
	def getCategoria = categoria
	def setCategoria(c:CategoriaBanda) = categoria = c
	  
	def precioCategoria : Double = categoria.precioExtra
}
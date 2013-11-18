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
	  this.nombre_(nom)
	  this.categoria_ (cat)
	}
  
	var _nombre:String = _
	var _categoria:CategoriaBanda = _
	
	def nombre_(n:String) = _nombre = n
	@PersistentField
	def nombre = _nombre
	
	
	def categoria_(c:CategoriaBanda) = _categoria = c
	@Relation
	def categoria = _categoria
	
	  
	def precioCategoria : Double = categoria.precioExtra
}
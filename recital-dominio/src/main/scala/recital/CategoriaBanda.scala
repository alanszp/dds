package recital

import uqbar.arena.persistence.annotations.PersistentField
import uqbar.arena.persistence.annotations.PersistentClass
import org.uqbar.commons.model.Entity
import compatibility.DomainEntity

@PersistentClass
class CategoriaBanda extends DomainEntity {
	var _tipo: String = _
	var _precioExtra: Double = _
	
	def this(tipo: String, precioExtra: Double) = {
	  this()
	  this._tipo = tipo
	  this._precioExtra = precioExtra
	}
	
	def tipo(t:String) = _tipo = t
	@PersistentField
	def tipo = _tipo
	
	
	def precioExtra(p:Double) = _precioExtra = p
	@PersistentField
	def precioExtra = _precioExtra
	
}
package recital

import uqbar.arena.persistence.annotations.PersistentField
import uqbar.arena.persistence.annotations.PersistentClass
import org.uqbar.commons.model.Entity
import compatibility.DomainEntity

@PersistentClass
class CategoriaBanda extends DomainEntity {
	var tipo: String = _
	var precioExtra: Double = _
	
	def this(tipo: String, precioExtra: Double) = {
	  this()
	  this.tipo = tipo
	  this.precioExtra = precioExtra
	}
	
	@PersistentField
	def getTipo = tipo
	def setTipo(t:String) = tipo = t
	
	@PersistentField
	def getPrecioExtra = precioExtra
	def setPrecioExtra(p:Double) = precioExtra = p
}
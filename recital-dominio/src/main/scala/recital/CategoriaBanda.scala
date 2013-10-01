package recital

class CategoriaBanda () {
	var tipo: String = _
	var precioExtra: Double = _
	
	def this(tipo: String, precioExtra: Double) = {
	  this()
	  this.tipo = tipo
	  this.precioExtra = precioExtra
	}
}
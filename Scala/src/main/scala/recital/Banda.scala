package recital

class Banda (){
	def this(nom:String, cat:CategoriaBanda) = {
	  this()
	  this.nombre = nom
	  this.categoria = cat
	}
  
	var nombre:String = _
	var categoria:CategoriaBanda = _
	
	def precioCategoria : Double = categoria.precioExtra
}
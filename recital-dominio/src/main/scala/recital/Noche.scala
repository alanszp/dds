package recital

class Noche extends Serializable {
	
	def this(fecha: String) = {
	  this()
	  this.fecha = fecha
	}
	var nombreNoche: String = _
	var fecha: String = _
	var bandas: Set[Banda] = Set()
	var descuentos: Set[CategoriaPersona] = Set()
	var sectores : Set[Sector] = Set()
	
	def valorExtra : Double = this.bandas.maxBy(x => x.precioCategoria).precioCategoria
	
	def tieneDescuento(categoriaPersona : CategoriaPersona) = {
	  if (!this.descuentos.contains(categoriaPersona)) {
	    throw new CategoriaNoValidaException
	  }
	  
	}
	
	//def valorExtra = descuentos.foreach (b => b.aplicarDescuento(EntradaBase))

}
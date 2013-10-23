package recital

class Noche{
	
	def this(fecha: String) = {
	  this()
	  this.fecha = fecha
	}
  
	var numeroNoche: Int = _
	var fecha: String = _
	var bandas: Set[Banda] = Set()
	var descuentos: Set[CategoriaPersona] = Set()
	
	def valorExtra : Double = this.bandas.maxBy(x => x.precioCategoria).precioCategoria
	def tieneDescuento(categoriaPersona : CategoriaPersona) = {
	  if (!this.descuentos.contains(categoriaPersona)) {
	    throw new CategoriaNoValidaException
	  }
	  
	}
	
	//def valorExtra = descuentos.foreach (b => b.aplicarDescuento(EntradaBase))

}
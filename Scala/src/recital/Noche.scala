package recital

class Noche (var fecha: String){
	
	var bandas: Set[Banda] = Set()
	
	var descuentos: Set[CategoriaPersona] = Set()
	
	def valorExtra : Double = this.bandas.maxBy(x => x.precioCategoria).precioCategoria
	
	//def valorExtra = descuentos.foreach (b => b.aplicarDescuento(EntradaBase))

}
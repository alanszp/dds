package recital

class Noche (var fecha: String){
	
	var bandas: Set[Banda] = Set()
	
	def valorExtra : Double = this.bandas.maxBy(x => x.precioCategoria).precioCategoria

}
package recital

class Noche (var fecha: String){
	
	var bandas: Set[Banda] = Set()
	
	def valorExtra() = bandas.maxBy(x => x.precioCategoria()) 

}
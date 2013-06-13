class Noche (Fecha: String){
  
	var bandas: Set[Banda] = Set()
	
	def valorExtra() = this.bandas collect {case banda: Banda => banda.categoria.precio} max

}
class Deposito {
  
   var fabricados: Set[Componente] = Set()
   var reservados: Set[Componente] = Set()


   def hayReservados(comp: Componente): Boolean = this.reservados.contains(comp)
   def quitarReservados(comp: Componente) { this.reservados -= comp }
   def agregarReservados(comp: Componente) { this.reservados += comp }
   def hayFabricados(comp: Componente): Boolean = this.fabricados.contains(comp)
   def quitarFabricados(comp: Componente) { this.fabricados -= comp }
   def agregarFabricados(comp: Componente) { this.fabricados += comp }
   
}
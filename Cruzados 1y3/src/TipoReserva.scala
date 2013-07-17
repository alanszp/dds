abstract class TipoReserva {
	
  def reservar(componente:Componente, fabrica:Fabrica) = {
        if (fabrica.deposito.hayFabricados(componente)) {
            fabrica.deposito.agregarReservados(componente)
            fabrica.deposito.quitarFabricados(componente)
        } else {
            fabrica.deposito.agregarReservados(fabrica.produccion.crear(componente))
        }
  }
}
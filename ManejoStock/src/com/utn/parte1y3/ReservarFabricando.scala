package com.utn.parte1y3

class ReservarFabricando extends TipoReserva {
	def reservar(producto:String, fabrica:Fabrica){	
	  val deposito = fabrica.deposito
	  val produccion = fabrica.produccion
		if (deposito.hayFabricados(producto)) {
            deposito.agregarReservados(deposito.quitarFabricados(producto))
        } else {
            deposito.agregarReservados(produccion.crear(producto))
        }
	}
}
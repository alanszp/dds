package com.utn.parte1y3

import com.utn.comun.Componente

class ReservarFabricando extends TipoReserva {
	def reservar(producto:Componente, fabrica:Fabrica){	
	  val deposito = fabrica.deposito
	  val produccion = fabrica.produccion
		if (deposito.hayFabricados(producto)) {
            deposito.agregarReservados(deposito.quitarFabricados(producto.nombre))
        } else {
            deposito.agregarReservados(produccion.crear(producto.nombre))
        }
	}
}
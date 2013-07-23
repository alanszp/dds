package com.utn.parte1y3

import com.utn.comun.Componente

class ReservarSinFabricar extends TipoReserva {
  def reservar(producto:String, fabrica:Fabrica){	
	  val deposito = fabrica.deposito
	  val produccion = fabrica.produccion
		if (deposito.hayFabricados(producto)) {
            deposito.agregarReservados(deposito.quitarFabricados(producto))
        } else {
        	var productoCreado = produccion.crearSiHayStock(producto)
        	if (productoCreado != null) {
        	  deposito.agregarReservados(productoCreado)
        	}
        }
  }
}
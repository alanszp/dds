package com.utn.parte2y4

class EventoStockMinimo extends ManejadorEventos {

  def reservar(componente:String) = {
		tipoReserva.reservar(componente, this)
	}
}
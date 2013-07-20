package com.utn.parte1y3

import com.utn.comun.Deposito
import com.utn.comun.Componente

class Fabrica (var deposito: Deposito, var produccion: Produccion, var tipoReserva:TipoReserva){

	def reservar(componente:Componente):Componente = {
		tipoReserva.reservar(componente, this)
	}
  
}
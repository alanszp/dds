package com.utn.parte1y3

import com.utn.comun.Componente
import com.utn.comun.Deposito


class Fabrica (var deposito: Deposito, var produccion: Produccion){
	var tipoReserva:TipoReserva = new ReservarFabricando //Para no poner null... Asi si algun colgado se olvida, por lo menos tiene eso!
	
	def setTipoReserva(tipo:TipoReserva) = {
	  tipoReserva = tipo
	}
	
	def reservar(componente:String) = {
		tipoReserva.reservar(componente, this)
	}
	
  
}
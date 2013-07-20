package com.utn.parte1y3

class Fabrica (var deposito: Deposito, var produccion: Produccion, var tipoReserva:TipoReserva){
	var diccionario:Map[String, Producto]
	
	def reservar(componente:Componente):Componente = {
		tipoReserva.reservar(componente, this)
	}
  
}
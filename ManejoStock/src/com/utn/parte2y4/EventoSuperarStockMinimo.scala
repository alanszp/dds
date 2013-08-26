package com.utn.parte2y4

import com.utn.comun.Producto

class EventoSuperarStockMinimo extends ManejadorEventos {
    
	  
	def manejar(producto: Producto, cantEnDeposito: Int, cant: Int){
	  
	  //veo cuando falta en deposito para llegar al stock minimo
	  val diferencia = producto.cantMinima - cantEnDeposito;
	  
	  //si necesita log y supere el stock minimo lo logeo
	  if(producto.necesitaLog && (cant >= diferencia)){
	    //IMPRIMO POR PANTALLA (VER COMO HACERLO DESP PARA LOS TEST)
	  }
	  
	}
}
package com.utn.parte2y4

import com.utn.comun.Producto

class EventoSuperarStockMaximo extends ManejadorEventos {
    
	  
	def manejar(producto: Producto, cantEnDeposito: Int, cant: Int){
	  
	  //veo cuanto va a haber en el deposito luego del ingreso de productos
	  val cantTotal = cantEnDeposito + cant;
	  
	  //si necesita log y supere el stock maximo lo logeo
	  if(producto.necesitaLog && (cantTotal > producto.cantMaxima)){
	    //IMPRIMO POR PANTALLA (VER COMO HACERLO DESP PARA LOS TEST)
	  }
	  
	}
}
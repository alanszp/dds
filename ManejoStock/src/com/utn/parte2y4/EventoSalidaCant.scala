package com.utn.parte2y4
import com.utn.comun._

class EventoSalidaCant extends ManejadorEventos {
  
def manejar(producto: Producto, cantEnDeposito: Int, cantSalieron: Int){ 
   if(producto.necesitaLog && (cantSalieron >= producto.cantCriticas)){
     
	   //GENERO MAIL
	   enviarMail(producto, cantSalieron)
   }

 }

def enviarMail(producto:Producto, cantSalieron:Int){
  //FUERA DE NUESTRO ALCANCE
}

}
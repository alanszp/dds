package com.utn.parte2y4
import com.utn.comun._

class EventoSalidaStockMinimo extends ManejadorEventos {
  
	//RECIBO PRODUCTO, CANTENDEPOSITO, CANT A SACAR
def manejar(producto: Producto, cantEnDeposito: Int, cant: Int){ 
   if(cantEnDeposito < producto.cantMinima){
     
	   //GENERO PEDIDO DE COMPRA
	   var pedidoCompra:PedidoDeCompra = new PedidoDeCompra(producto, producto.puntoDePedido)
	   enviarACompras(pedidoCompra)
	   //GENERO AUDITORIA
	   if (producto.necesitaLog==true) generarLogAuditoria(producto)
   }

 }

def enviarACompras(pedido:PedidoDeCompra){
  //FUERA DE NUESTRO ALCANCE
}

def generarLogAuditoria(producto:Producto){
  var msg:String = "El stock del producto "+producto.nombre+" se encuentra por debajo del minimo aceptable. Fecha "+ getFechaActual
	msg
}

def getFechaActual{
  //harcodeado
  return "01/12/2013"
}
  
}
  
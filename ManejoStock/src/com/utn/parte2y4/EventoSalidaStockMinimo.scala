package com.utn.parte2y4
import com.utn.comun._
//import org.joda.time
//import org.joda.time.convert

class EventoSalidaStockMinimo extends ManejadorEventos {
  
	//RECIBO PRODUCTO, CANTENDEPOSITO, CANT A SACAR
def manejar(producto: Producto, cantEnDeposito: Int, cant: Int){ 
   if(cantEnDeposito < producto.cantMinima){
     
	   //GENERO PEDIDO DE COMPRA
	   var pedidoCompra:PedidoCompra = new PedidoCompra(producto, producto.puntoDePedido)
	   enviarACompras(pedidoCompra)
	   //GENERO AUDITORIA
	   if (producto.necesitaLog) generarLogAuditoria(producto)
   }

 }

//ENVIARLE AL DEPTO DE COMPRAS
def enviarACompras(pedido:PedidoCompra){
  
}

def generarLogAuditoria(producto:Producto){
  var msg:String = "El stock del producto "+producto.nombre+" se encuentra por debajo del minimo aceptable. Fecha "+ getFechaActual
	msg
}

def getFechaActual{
  //val fechaActual: LocalDate = new LocalDate(anio, mes, dia)
}
  
}
  
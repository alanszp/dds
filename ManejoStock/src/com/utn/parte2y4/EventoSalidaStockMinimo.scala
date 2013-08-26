package com.utn.parte2y4
import com.utn.comun._

class EventoSalidaStockMinimo extends ManejadorEventos {
  
	//RECIBO PRODUCTO, CANTENDEPOSITO, CANT A SACAR
def manejar(producto: Producto, cantEnDeposito: Int, cant: Int){ 
   if(cantEnDeposito < producto.cantMinima){
     
	   //GENERO PEDIDO DE COMPRA
	   var pedidoCompra:PedidoDeCompra = new PedidoDeCompra(producto, producto.puntoDePedido)
	   enviarACompras(pedidoCompra)
   }
 }

def enviarACompras(pedido:PedidoDeCompra){
  //FUERA DE NUESTRO ALCANCE
}
  
}
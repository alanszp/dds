/*package com.utn.parte2y4

class Producto{
  val nombre: String
  val cantMinima  : Int
  val cantMaxima : Int
  val puntoDePedido : Int

  
  val log: Boolean
  val unidadesCriticas: Int
}


class Deposito {
    var productos:  Set[Producto] = Set()
    var manejadorIngreso:   Set[ManejadorEventos] = Set()
    var manejadorSalida:  Set[ManejadorEventos] = Set()
    
    def removerProd(producto: Producto) = this.productos -= producto
    def agregarProd(producto: Producto) = this.productos += producto
    
    //Metodos auxiliares
    def cuantos(producto: Producto ): Int = this.productos.count(_ == productos)
    
    
    //Metodos dise�ados
    def sacar(producto: Producto, cantidad: Int) = {
        //Saca de la lista `cantidad` de veces
        (1 to cantidad).foreach( _ => this.removerProd(producto) )
        //Informa a los handelers corespondientes
        (this.manejadorSalida).foreach( (m) => m.manejar(producto, cantidad) )
    }
    
    def agregar(producto: Producto, cantidad: Int) = {
        //Saca de la lista `cantidad` de veces
        (1 to cantidad).foreach( _ => this.agregarProd(producto) )
        //Informa a los handelers corespondientes
        (this.manejadorIngreso).foreach( (m) => m.manejar(producto, cantidad) )
    }
  
}
 
abstract class ManejadorEventos3
{
    //Solo es un contrato
    def manejar(producto: Producto, cantidad: Int)
}
 
 
//Debe generarse un pedido de compra si el producto baj� por sobre su stock m�nimo. 
class EventoSalidaStockMinimo3 extends ManejadorEventos
{
    def manejar(producto: Producto, cantidad: Int) ={
        val cantidadFaltante: Int = producto.cantMinima - Deposito.cuantos(producto)
        
        //Si faltan productos
        if(cantidadFaltante <= 0 )
            //Informa al Departamento de Compras con cuantas faltan
            DepartamentoCompras.armarNotaCompras(producto, cantidadFaltante)
    }
}
 
 
//Algunos productos al bajar el stock m�nimo generan un log de auditor�a 
class EventoStockMinimo3 extends ManejadorEventos
{    
    def manejar(producto: Producto, cantidad: Int) ={
        val cantidadFaltante: Int = producto.cantMinima - Deposito.cuantos(producto)
        
        //Si nos interesa logear y bajo el minimo
        if(producto.importaLog && cantidadFaltante <= 0)
            //Genera el Log
            AuditoriaLoger.log("Se compraron " + -cantidadFaltante + " " + producto.nombre +  " mas del stock minimo definido")
    }
}
 
 
//Para algunos productos nos interesa enviar un mail si un determinado producto tuvo una salida de m�s de x unidad
class EventoSalidaCant3 extends ManejadorEventos
{    
    def manejar(producto: Producto, cantidad: Int) ={        
        //Si nos interesa logear y por sobre la cantidad critica
        if(producto.importaLog && producto.unidadesCriticas <= cantidad)
            //Manda el mail
            AuditoriaLoger.mail("Se compraron " + cantidad + " " + producto.nombre +  ". Estas avisado!")
    }
}
 
 
//Algunos productos registran en el log de auditor�a cuando dejan de estar por debajo del stoc
class EventoSuperarStockMinimo3 extends ManejadorEventos
{    
    def manejar(producto: Producto, cantidad: Int) ={
        val cantidadFaltante: Int = producto.cantMinima - Deposito.cuantos(producto)
        
        //Si nos interesa logear si estaba por dejabo, pero ya no mas
        if(producto.importaLog && cantidadFaltante >= cantidad )
            //Genera el Log
            AuditoriaLoger.log("Se compraron " + -cantidadFaltante + " " + producto.nombre +  " mas del stock minimo definido")
    }
}
 
 
//Otros productos avisan cuando al ingresar mercader�a exceden el stock m�ximo posible.
class EventoSuperarStockMaximo3 extends ManejadorEventos
{    
    def manejar(producto: Producto, cantidad: Int) ={
        val cantidadSobrante: Int = producto.cantMaxima - Deposito.cuantos(producto)
        
        //Si nos interesa logear y sobre el maximo
        if(producto.importaLog && cantidadSobrante >= 0)
            //Genera el Log
            AuditoriaLoger.log("Se compraron " + cantidadSobrante + " " + producto.nombre +  " mas del stock maximo definido")
    }
}
 
 
//Mocks
class AuditoriaLoger3
{
    def log(s: String) = println(s)
    def mail(s: String) = println(s)
}
 
class DepartamentoCompras3
{
    def armarNotaCompras(c: Producto, i: Int) = println("Comprar " + i + " " + c.nombre)
}*/
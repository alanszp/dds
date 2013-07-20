abstract class Producto
{
  val nombre: String
  val cantMinima  : Int
  val cantMaxima : Int
  val puntoDePedido : Int

  
  val log: Boolean
  val unidadesCriticas: Int
}
 
(val cantMinima:Int, val cantMaxima:Int, val puntoDePedido:Int, val nombre:String, val importaLog:Boolean, val unidadesCriticas:Int) extends Producto
{  
  var productos: Set[Producto] = Set()
}

//singleton Deposito 
object Deposito
{
    var productos:  Set[Producto] = Set()
    var manejadorIngreso:   Set[ManejadorEventos] = Set()
    var manejadorSalida:  Set[ManejadorEventos] = Set()
    
    def removerProd(producto: Producto) = this.productos -= producto
    def agregarProd(producto: Producto) = this.productos += producto
    
    //Metodos auxiliares
    def cuantos(producto: Producto ): Int = this.productos.count(_ == productos)
    
    
    //Metodos diseñados
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
 
abstract class ManejadorEventos
{
    //Solo es un contrato
    def manejar(producto: Producto, cantidad: Int)
}
 
 
//Debe generarse un pedido de compra si el producto bajó por sobre su stock mínimo. 
class EventoSalidaStockMinimo extends ManejadorEventos
{
    def manejar(producto: Producto, cantidad: Int) ={
        val cantidadFaltante: Int = producto.cantMinima - Deposito.cuantos(producto)
        
        //Si faltan productos
        if(cantidadFaltante <= 0 )
            //Informa al Departamento de Compras con cuantas faltan
            DepartamentoCompras.armarNotaCompras(producto, cantidadFaltante)
    }
}
 
 
//Algunos productos al bajar el stock mínimo generan un log de auditoría 
class EventoStockMinimo extends ManejadorEventos
{    
    def manejar(producto: Producto, cantidad: Int) ={
        val cantidadFaltante: Int = producto.cantMinima - Deposito.cuantos(producto)
        
        //Si nos interesa logear y bajo el minimo
        if(producto.importaLog && cantidadFaltante <= 0)
            //Genera el Log
            AuditoriaLoger.log("Se compraron " + -cantidadFaltante + " " + producto.nombre +  " mas del stock minimo definido")
    }
}
 
 
//Para algunos productos nos interesa enviar un mail si un determinado producto tuvo una salida de más de x unidad
class EventoSalidaCant extends ManejadorEventos
{    
    def manejar(producto: Producto, cantidad: Int) ={        
        //Si nos interesa logear y por sobre la cantidad critica
        if(producto.importaLog && producto.unidadesCriticas <= cantidad)
            //Manda el mail
            AuditoriaLoger.mail("Se compraron " + cantidad + " " + producto.nombre +  ". Estas avisado!")
    }
}
 
 
//Algunos productos registran en el log de auditoría cuando dejan de estar por debajo del stoc
class EventoSuperarStockMinimo extends ManejadorEventos
{    
    def manejar(producto: Producto, cantidad: Int) ={
        val cantidadFaltante: Int = producto.cantMinima - Deposito.cuantos(producto)
        
        //Si nos interesa logear si estaba por dejabo, pero ya no mas
        if(producto.importaLog && cantidadFaltante >= cantidad )
            //Genera el Log
            AuditoriaLoger.log("Se compraron " + -cantidadFaltante + " " + producto.nombre +  " mas del stock minimo definido")
    }
}
 
 
//Otros productos avisan cuando al ingresar mercadería exceden el stock máximo posible.
class EventoSuperarStockMaximo extends ManejadorEventos
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
object AuditoriaLoger
{
    def log(s: String) = println(s)
    def mail(s: String) = println(s)
}
 
object DepartamentoCompras
{
    def armarNotaCompras(c: Producto, i: Int) = println("Comprar " + i + " " + c.nombre)
}
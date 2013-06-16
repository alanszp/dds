package recital

class Mayor (PrecioDescuento: Double) extends CategoriaPersona {

   var precioDescuento: Double = PrecioDescuento
   
   override def aplicarDescuento(EntradaBase: Double):Double = {
     EntradaBase
   }
}
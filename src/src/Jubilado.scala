class Jubilado (PrecioDescuento: Double) extends CategoriaPersona{

   var precioDescuento: Double = PrecioDescuento
   
   override def aplicarDescuento(EntradaBase: Double):Double = {
     return (EntradaBase * this.precioDescuento)
   }
}
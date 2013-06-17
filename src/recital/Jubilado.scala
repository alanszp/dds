package recital

class Jubilado ( var precioDescuento: Double) extends CategoriaPersona{

   override def aplicarDescuento(EntradaBase: Double):Double = {
     return (EntradaBase * precioDescuento)
   }
}
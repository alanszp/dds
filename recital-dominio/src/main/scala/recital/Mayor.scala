package recital

import uqbar.arena.persistence.annotations.PersistentClass

@PersistentClass
class Mayor extends CategoriaPersona {
  
   val _descripcion = "Mayor"
   override def aplicarDescuento(EntradaBase: Double):Double = {
     0
   }
<<<<<<< HEAD
=======
   
   @PersistentField
   def descripcion = _descripcion
>>>>>>> 14d63d55bbb047955691907cb197d92b648481fb
}
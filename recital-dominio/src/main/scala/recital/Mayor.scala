package recital

import uqbar.arena.persistence.annotations.PersistentClass
import uqbar.arena.persistence.annotations.PersistentField

@PersistentClass
class Mayor extends CategoriaPersona {
  
   val _descripcion = "Mayor"
   override def aplicarDescuento(EntradaBase: Double):Double = {
     0
   }
   
   @PersistentField
   def descripcion = _descripcion
}
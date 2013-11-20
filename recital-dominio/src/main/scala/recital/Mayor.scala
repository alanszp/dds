package recital

import uqbar.arena.persistence.annotations.PersistentClass

@PersistentClass
class Mayor extends CategoriaPersona {
  
   val descripcion = "Mayor"
   override def aplicarDescuento(EntradaBase: Double):Double = {
     0
   }
}
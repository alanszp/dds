package recital

import uqbar.arena.persistence.annotations.PersistentClass


class Mayor extends CategoriaPersona {
  
   val _descripcion = "Mayor"
   override def aplicarDescuento(EntradaBase: Double):Double = {
     0
   }
}
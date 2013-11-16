package recital

import uqbar.arena.persistence.annotations.PersistentField
import javax.management.relation.Relation

class Sector extends Serializable {
  
  def this(nombre: String) = {
    this()
    this.nombre = nombre
  }
  
  var nombre: String =_
  var filas: Set[RangoFilas] = Set()
  
  @PersistentField
  def getNombre = nombre
  def setNombre(n:String) = nombre = n
	
  @Relation
  def getFilas = filas
  def setFilas(f:Set[RangoFilas]) = filas = f
  
  def valorEntradaBase(numero: Int): Double ={
    val fila = buscarFila(numero)
    	
    fila.precio
  }
  
  def verificarUbicacion(fila:Int, asiento:Int) = {
    val filaEncontrada = buscarFila(fila)
    
    if( !(filaEncontrada.existeAsiento(asiento)) ){
      throw new AsientoIncorrectoException
    }
  }
  
  def buscarFila(numero: Int): RangoFilas = {
    var fila = filas.find{fila: RangoFilas => fila.tengoFila(numero)}
    
    if (fila.isEmpty) 
    	throw new FilaIncorrectaException      
    	
    fila.get
  }
  
 
}
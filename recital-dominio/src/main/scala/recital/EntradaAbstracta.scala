package recital

abstract class EntradaAbstracta extends Serializable {

  def precioEntrada:Double
  def cantidadDeEntradas:Int
  def sosOLaTenes(entrada:EntradaAbstracta):Boolean
  def entradas:Set[Entrada]
  
}
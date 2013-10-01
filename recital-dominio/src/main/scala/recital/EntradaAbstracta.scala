package recital

abstract class EntradaAbstracta {
	
  def precioEntrada:Double
  def cantidadDeEntradas:Int
  def sosOLaTenes(entrada:EntradaAbstracta):Boolean
}
package recital

abstract class entradaAbstracta {
	
  def precioEntrada:Double
  def cantidadDeEntradas:Int
  def sosOLaTenes(entrada:entradaAbstracta):Boolean
}
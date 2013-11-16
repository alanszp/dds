package recital

import org.uqbar.commons.model.Entity

abstract class EntradaAbstracta extends Entity {

  def precioEntrada:Double
  def cantidadDeEntradas:Int
  def sosOLaTenes(entrada:EntradaAbstracta):Boolean
  def entradas:Set[Entrada]
  
}
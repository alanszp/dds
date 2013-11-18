package recital

import org.uqbar.commons.model.Entity
import compatibility.DomainEntity

abstract class EntradaAbstracta extends DomainEntity {

  def precioEntrada:Double
  def cantidadDeEntradas:Int
  def sosOLaTenes(entrada:EntradaAbstracta):Boolean
  def entradas:Set[Entrada]
  
}
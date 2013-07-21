package com.utn.parte1y3

import com.utn.comun._

abstract class TipoReserva {
  def reservar(producto:Componente, fabrica:Fabrica)
}
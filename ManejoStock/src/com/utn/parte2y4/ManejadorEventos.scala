package com.utn.parte2y4

import com.utn.comun.Producto

abstract class ManejadorEventos {
  def manejar(producto: Producto, cantidad: Int)
}
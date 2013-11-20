package appmodel

import scala.collection.JavaConversions
import scala.collection.mutable.ListBuffer
import recital.Banda
import recital.CategoriaBanda
import recital.CategoriaPersona
import recital.CoreDeVentas
import recital.Damas
import recital.Entrada
import recital.EntradaAbstracta
import recital.Jubilado
import recital.Mayor
import recital.Menor
import recital.Menor12
import recital.Noche
import recital.RangoFilas
import recital.Sector
import home.HomeEntradas

@org.uqbar.commons.utils.Observable
class ListadorEntrada extends Serializable {


  private var _nocheRecital: String = _
  private var _nombreCliente: String = _

  var listaEntradas: java.util.List[Entrada] = _
  var entradaSeleccionada: Entrada = _

  def nocheRecital_=(noche: String) = {
    _nocheRecital = noche
    search
  }
  def nocheRecital = _nocheRecital

  def nombreCliente_=(cliente: String) = {
    _nombreCliente = cliente
    search
  }
  def nombreCliente = _nombreCliente

  def clear {
    _nocheRecital = null
    _nombreCliente = null
    search
  }

  def search {
    listaEntradas = todasLasEntradas
  }

  def anularEntradaSeleccionada {
    HomeEntradas.delete(entradaSeleccionada)
    search
  }

  def buscarEntradas: java.util.List[Entrada] = {
    HomeEntradas.searchClienteYNoche(nombreCliente, nocheRecital)
  }
 
  def todasLasEntradas: java.util.List[recital.Entrada] = HomeEntradas.entradas 

  
  def campoVacio(campo: String): Boolean = {
    campo == "" || campo == null
  }
 
}

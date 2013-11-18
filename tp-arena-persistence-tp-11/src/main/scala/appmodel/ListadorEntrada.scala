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

  var coreVentas = new CoreDeVentas

  private var _noche: Noche = _
  private var _nocheRecital: String = _
  private var _nombreCliente: String = _

  var listaEntradas: java.util.List[Entrada] = _
  var entradaSeleccionada: Entrada = _

  def nocheRecital_=(noche: String) = {
    _nocheRecital = noche
    search
  }
  def nocheRecital = _nocheRecital

  def noche_=(noche1: Noche) = {
    _noche = noche1
    search
  }
  def noche = _noche

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
    listaEntradas = buscarEntradas
  }

  def anularEntradaSeleccionada {
    coreVentas.anularEntrada(entradaSeleccionada)
    search
  }

/*  def buscarEntradas: java.util.List[Entrada] = {
    JavaConversions.asJavaList(filtrarEntradas)
  }*/

  def buscarEntradas: java.util.List[Entrada] = {
    var entradas = HomeEntradas.entradas
    entradas = filtrarEntradasPorCliente(entradas)
    filtrarEntradasPorNoche(entradas)
  }

  def filtrarEntradasPorNoche(coleccion: java.util.List[Entrada]): java.util.List[Entrada] = {
    if (campoVacio(_nocheRecital)) {
      return coleccion
    }
    HomeEntradas.filtrarPorNoche(_nocheRecital)
  }

  def filtrarEntradasPorCliente(coleccion: java.util.List[Entrada]): java.util.List[Entrada] = {
    if (campoVacio(_nombreCliente)) {
      return coleccion
    }
    HomeEntradas.filtrarPorCliente(_nombreCliente)
  }
 
  def todasLasEntradas: java.util.List[recital.Entrada] = {
    HomeEntradas.entradas //VER COMO USAR HOMEENTRADAS.TODASLASENTRADAS
  }  

  
  def setToBuffer[T](set : Set[T]) : ListBuffer[T] = {
    var lista: ListBuffer[T] = ListBuffer()
    set.foreach(entrada => lista += entrada)
    lista
  }

  def campoVacio(campo: String): Boolean = {
    campo == "" || campo == null
  }
 
}
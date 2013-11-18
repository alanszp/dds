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

  def buscarEntradas: java.util.List[Entrada] = {
    JavaConversions.asJavaList(filtrarEntradas)
  }

  def filtrarEntradas: ListBuffer[Entrada] = {
    var entradas = todasLasEntradas
    entradas = filtrarEntradasPorCliente(entradas)
    filtrarEntradasPorNoche(entradas)
  }

  def filtrarEntradasPorNoche(coleccion: ListBuffer[Entrada]): ListBuffer[Entrada] = {
    if (campoVacio(_nocheRecital)) {
      return coleccion
    }
    coleccion.filter(entrada => entrada.noche.fecha contains _nocheRecital)
  }

  def filtrarEntradasPorCliente(coleccion: ListBuffer[Entrada]): ListBuffer[Entrada] = {
    if (campoVacio(_nombreCliente)) {
      return coleccion
    }
    coleccion.filter(entrada => entrada.cliente.toLowerCase().contains(_nombreCliente.toLowerCase()))
  }

  def todasLasEntradas: ListBuffer[Entrada] = {
    setToBuffer[Entrada](coreVentas.entradas.flatMap(_.entradas)) //VER COMO USAR HOMEENTRADAS.TODASLASENTRADAS
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
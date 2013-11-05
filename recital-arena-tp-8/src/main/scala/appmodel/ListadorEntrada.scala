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
class ComprarEntradaAppModel extends Serializable {

  var coreVentas = new CoreDeVentas

  private var _noche: Noche = _
  private var _nocheRecital: String = _
  private var _nombreCliente: String = _

  var listaEntradas: java.util.List[Entrada] = _
  var entradaSeleccionada: Entrada = _
  var sectores: Set[Sector] = _
  var categorias: Set[CategoriaPersona] = _

  this.populate

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

  //------------------USAR EL MISMO APPMODEL----

  private var _apellidoCliente: String = _
  private var _categoriaCliente: CategoriaPersona = _
  private var _sector: Sector = _
  private var _fila: String = _
  private var _asiento: String = _

  def apellidoCliente_=(apellidoCliente: String) = {
    _apellidoCliente = apellidoCliente
  }
  def apellidoCliente = _apellidoCliente
  //

  def categoriaCliente_=(categoriaCliente: CategoriaPersona) = {
    _categoriaCliente = categoriaCliente
  }

  def categoriaCliente = _categoriaCliente

  def sector_=(sector: Sector) = {
    _sector = sector
  }

  def sector = _sector
  //
  def fila_=(fila: String) = {
    _fila = fila

  }
  def fila = _fila
  //
  def asiento_=(asiento: String) = {
    _asiento = asiento

  }
  def asiento = _asiento

  //-----------------------------------------------

  def populate = {

    sectores = Set()
    categorias = Set()

    var sectorA = new Sector("A")
    var sectorB = new Sector("B")
    var sectorC = new Sector("C")

    sectores += sectorA
    sectores += sectorB
    sectores += sectorC

    var fila1a10 = new RangoFilas(1, 10, 150, 20)
    var fila11a20 = new RangoFilas(11, 20, 70, 20)
    var fila21a30 = new RangoFilas(21, 30, 90, 20)

    sectorA.filas += fila1a10
    sectorB.filas += fila11a20
    sectorC.filas += fila21a30

    var noche1 = new Noche("19/10/13")
    var noche2 = new Noche("20/10/13")

    var categoria_nacionalPocoReconocida = new CategoriaBanda("Nacional Poco Reconocida", 0)
    var categoria_nacionalReconocida = new CategoriaBanda("Nacional Reconocida", 50)
    var categoria_nacionalReconocidaInternacionalmente = new CategoriaBanda("Nacional Reconocida Internacionalmente", 100)
    var categoria_internacional = new CategoriaBanda("Internacional", 200)

    var acdc = new Banda("acdc", categoria_internacional)
    var wachiturros = new Banda("acdc", categoria_nacionalPocoReconocida)

    var jubilado = new Jubilado(0.15)
    var menor = new Menor(10, 0.2)
    var mayor = new Mayor
    var damas = new Damas(0.2)
    var menorDe12 = new Menor12(0.5)

    categorias += jubilado
    categorias += menor
    categorias += mayor
    categorias += damas
    categorias += menorDe12

    noche1.bandas += acdc
    noche1.bandas += wachiturros
    noche1.descuentos = noche1.descuentos union Set(jubilado, menor, mayor, damas, menorDe12)

    noche2.bandas += wachiturros
    noche2.descuentos = noche2.descuentos union Set(jubilado, menor, mayor, damas, menorDe12)

    coreVentas.noches += noche1
    coreVentas.noches += noche2

    var entrada1 = new Entrada(sectorA, noche1, jubilado, 9, 2, "Pepe", "Abasto")
    var entrada2 = new Entrada(sectorA, noche1, jubilado, 9, 3, "Pepe", "Abasto")
    var entrada3 = new Entrada(sectorA, noche1, jubilado, 9, 4, "Pepe", "Abasto")
    var entrada4 = new Entrada(sectorB, noche2, mayor, 19, 19, "Luis", "Abasto")
    var entrada5 = new Entrada(sectorC, noche1, damas, 23, 5, "Maria", "Abasto")
    var entrada6 = new Entrada(sectorC, noche1, damas, 22, 6, "Maria", "Abasto")

    coreVentas.agregarEntrada(entrada1)
    coreVentas.agregarEntrada(entrada2)
    coreVentas.agregarEntrada(entrada3)
    coreVentas.agregarEntrada(entrada4)
    coreVentas.agregarEntrada(entrada5)
    coreVentas.agregarEntrada(entrada6)
  }

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
    var lista: ListBuffer[Entrada] = ListBuffer()
    coreVentas.entradas.flatMap(_.entradas).foreach(entrada => lista += entrada)
    lista
  }

  def campoVacio(campo: String): Boolean = {
    campo == "" || campo == null
  }

  def venderEntrada = {
    val entradaNueva = new Entrada(sector, noche, categoriaCliente, fila.toInt, asiento.toInt, nombreCliente, "Abasto")
    coreVentas.venderEntrada(entradaNueva)
    //search
  }
  
  def limpiarCampos = {
    _nombreCliente = null
    _apellidoCliente = null
    _fila = null
    _asiento = null
    _categoriaCliente = null
    _noche = null
    _sector = null
    search    
  }

  def sectoresList = JavaConversions.asJavaSet(sectores)
  //def sectoresMostrar = JavaConversions.asJavaSet(sectores.map(x=>x.nombre))

  def categoriasList = JavaConversions.asJavaSet(categorias)

  def nochesList = JavaConversions.asJavaSet(coreVentas.noches)
}
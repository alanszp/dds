package appmodel.webapp

import recital._
import scala.collection.JavaConversions
import java.util.List
import scala.collection.mutable.ListBuffer

class HomeEntradas{
  
  var homeEntradas : ListBuffer[Entrada]= ListBuffer()
  var nombreCliente = ""
  var fechaDesde = ""
  var fechaHasta = ""
  this.populate
  
  def populate = {
	  var sectorA = new Sector("A")
	  var sectorB = new Sector("B")
	  var sectorC = new Sector("C")
	  
	  var fila1a10 = new RangoFilas(1, 10, 150, 20)
	  var fila11a20 = new RangoFilas(11, 20, 70, 20)
	  var fila21a30 = new RangoFilas(21, 30, 90, 20)
	
	  sectorA.filas += fila1a10
	  sectorB.filas += fila11a20
	  sectorC.filas += fila21a30
	  
	  var noche1 = new Noche("18/10/13")
	  var noche2 = new Noche("25/10/13")
	  
	  var categoria_nacionalPocoReconocida = new CategoriaBanda("Nacional Poco Reconocida", 0)
	  var categoria_nacionalReconocida = new CategoriaBanda("Nacional Reconocida", 50)
	  var categoria_nacionalReconocidaInternacionalmente = new CategoriaBanda("Nacional Reconocida Internacionalmente", 100)
	  var categoria_internacional = new CategoriaBanda("Internacional", 200)
  
	  var acdc = new Banda("acdc", categoria_internacional)
	  var wachiturros = new Banda("acdc", categoria_nacionalPocoReconocida)
	 
	  var jubilado = new Jubilado(0.15)
	  var menor = new Menor(10,0.2)
	  var mayor = new Mayor
	  var damas = new Damas(0.2)
	  var menorDe12 = new Menor12(0.5)
	  
	  noche1.bandas += acdc
	  noche1.bandas += wachiturros
	  noche1.descuentos = noche1.descuentos union Set(jubilado, menor, mayor, damas, menorDe12)
  
	  noche2.bandas += wachiturros
	  noche2.descuentos = noche2.descuentos union Set(jubilado, menor, mayor, damas, menorDe12)

	  var entrada1 = new Entrada(sectorA, noche1, jubilado, 9, 2, "Pepe")
	  var entrada2 = new Entrada(sectorA, noche1, jubilado, 9, 3, "Pepe")
	  var entrada3 = new Entrada(sectorA, noche1, jubilado, 9, 4, "Pepe")
	  var entrada4 = new Entrada(sectorB, noche2, mayor, 19, 19, "Luis")
	  var entrada5 = new Entrada(sectorC, noche1, damas, 23, 5, "Maria")
	  var entrada6 = new Entrada(sectorC, noche1, damas, 22, 6, "Maria")
	 
	  homeEntradas += entrada1
	  homeEntradas += entrada2 
	  homeEntradas += entrada3
	  homeEntradas += entrada4
	  homeEntradas += entrada5
	  homeEntradas += entrada6
	}
  
  //variables para los filtros
  def getCliente = nombreCliente
  def setCliente(cliente:String) = this.nombreCliente = cliente
  
  def getFechaDesde = fechaDesde
  def setFechaDesde(desde:String) = this.fechaDesde = desde
  
  def getFechaHasta = fechaHasta
  def setFechaHasta(hasta:String) = this.fechaHasta = hasta
  
  //obtener el conjunto de entradas tras el filtro del cliente
  def getEntradasCliente : java.util.List[Entrada] = {
		  JavaConversions.asJavaList(filtrarEntradasCliente(nombreCliente))
	}
  
  //UNIFICARTODO
  
  //filtrar por cliente
  def filtrarEntradasCliente(cliente:String) : ListBuffer[Entrada]= {
	  if (cliente == "") {
	    return homeEntradas
	  }
	  homeEntradas.filter(entrada => entrada.cliente == cliente)
	}
  
  //obtener el conjunto de entradas tras el filtro de las fechas
  def getEntradasFecha : java.util.List[Entrada] = {
		  JavaConversions.asJavaList(filtrarEntradasFecha(fechaDesde,fechaHasta))
  }
  
  //filtrar por fecha
  def filtrarEntradasFecha (fechaDesde:String, fechaHasta:String) : ListBuffer [Entrada] = {
    if (fechaDesde == "" && fechaHasta == "") {
	    return homeEntradas
	  }
    	homeEntradas.filter (entrada => (entrada.noche.fecha > fechaDesde) && (entrada.noche.fecha < fechaHasta)) 
  }
}

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
  
  def populate= {
	  var sectorA = new Sector("A")
	  var sectorB = new Sector("B")
	  var sectorC = new Sector("C")
	  
	  var fila1a10 = new RangoFilas(1, 10, 150, 20)
	  var fila11a20 = new RangoFilas(11, 20, 70, 20)
	
	  sectorA.filas += fila1a10
	  sectorB.filas += fila11a20
	  
	  var noche1 = new Noche("18/10/13")
	  var noche2 = new Noche("25/10/13")
	  
	  var jubilado = new Jubilado(0.15)
	  var menor = new Menor(10,0.2)
	  var mayor = new Mayor
	  var damas = new Damas(0.2)
	  var menorDe12 = new Menor12(0.5)
	  
	  var entrada1 = new Entrada(sectorA, noche1, jubilado, 10, 2, "Pepe")
	  var entrada2 = new Entrada(sectorA, noche1, jubilado, 10, 3, "Pepe")
	  var entrada3 = new Entrada(sectorA, noche1, jubilado, 10, 4, "Pepe")
	  var entrada4 = new Entrada(sectorB, noche2, mayor, 1, 10, "Luis")
	  var entrada5 = new Entrada(sectorC, noche1, damas, 19, 5, "Maria")
	  var entrada6 = new Entrada(sectorC, noche1, damas, 19, 6, "Maria")
	 
	  homeEntradas += entrada1
	  homeEntradas += entrada2 
	  homeEntradas += entrada3
	  homeEntradas += entrada4
	  homeEntradas += entrada5
	  homeEntradas += entrada6
	}
  
  //variables para los filtros
  def getCliente = nombreCliente
  def getCliente(cliente:String) = this.nombreCliente = cliente
  
  def getFechaDesde = fechaDesde
  def getFechaDesde(desde:String) = this.fechaDesde = desde
  
  def getFechaHasta = fechaHasta
  def getFechaHasta(hasta:String) = this.fechaHasta = hasta
  
  //obtener el conjunto de entradas tras el filtro del cliente
  def getEntradasCliente : java.util.List[Entrada] = {
		  JavaConversions.asJavaList(filtrarEntradasCliente(nombreCliente))
	}
  
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
    	homeEntradas.filter (entrada => (entrada.noche.fecha >fechaDesde) && (entrada.noche.fecha < fechaHasta)) 
  }
  
}

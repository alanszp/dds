package appmodel.webapp

import scala.collection.JavaConversions
import scala.collection.mutable.ListBuffer

import recital.Banda
import recital.CategoriaBanda
import recital.Damas
import recital.Entrada
import recital.Jubilado
import recital.Mayor
import recital.Menor
import recital.Menor12
import recital.Noche
import recital.RangoFilas
import recital.Sector

class HomeFestivales extends AbstractModel {
  var homeFestivales: ListBuffer[Entrada] = ListBuffer()
  var puestoVenta = ""
  var festival = ""
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
    var noche3 = new Noche("30/11/13")
    var noche4 = new Noche("04/12/13")

    var categoria_nacionalPocoReconocida = new CategoriaBanda("Nacional Poco Reconocida", 0)
    var categoria_nacionalReconocida = new CategoriaBanda("Nacional Reconocida", 50)
    var categoria_nacionalReconocidaInternacionalmente = new CategoriaBanda("Nacional Reconocida Internacionalmente", 100)
    var categoria_internacional = new CategoriaBanda("Internacional", 200)

    var acdc = new Banda("acdc", categoria_internacional)
    var wachiturros = new Banda("wachiturros", categoria_nacionalPocoReconocida)
    var borbotones = new Banda("borbotones", categoria_internacional)
    var rolling = new Banda("rolling stones", categoria_internacional)
    var bersuit = new Banda("besuit vergarabat", categoria_nacionalReconocidaInternacionalmente)

    var jubilado = new Jubilado(0.15)
    var menor = new Menor(10, 0.2)
    var mayor = new Mayor
    var damas = new Damas(0.2)
    var menorDe12 = new Menor12(0.5)

    noche1.bandas += acdc
    noche1.bandas += wachiturros
    noche1.descuentos = noche1.descuentos union Set(jubilado, menor, mayor, damas, menorDe12)

    noche2.bandas += wachiturros
    noche2.bandas += rolling
    noche2.descuentos = noche2.descuentos union Set(jubilado, menor, mayor, damas, menorDe12)

    noche3.bandas += rolling
    noche3.bandas += bersuit
    noche3.bandas += borbotones
    noche3.descuentos = noche3.descuentos union Set(jubilado, menor, mayor, damas, menorDe12)

    noche4.bandas += borbotones
    noche4.descuentos = noche4.descuentos union Set(jubilado, menor, mayor, damas, menorDe12)

    var entrada1 = new Entrada(sectorA, noche1, jubilado, 9, 2, "Pepe", "Abasto")
    var entrada2 = new Entrada(sectorA, noche1, jubilado, 9, 3, "Pepe", "Abasto")
    var entrada3 = new Entrada(sectorA, noche1, jubilado, 9, 4, "Pepe", "Abasto")
    var entrada4 = new Entrada(sectorB, noche2, mayor, 19, 19, "Luis", "Corrientes 200")
    var entrada5 = new Entrada(sectorC, noche1, damas, 23, 5, "Maria", "Alto Palermo")
    var entrada6 = new Entrada(sectorC, noche1, damas, 22, 6, "Maria", "Alto Palermo")

    homeFestivales += entrada1
    homeFestivales += entrada2
    homeFestivales += entrada3
    homeFestivales += entrada4
    homeFestivales += entrada5
    homeFestivales += entrada6
  }

  def getPuesto = puestoVenta
  def setPuesto(puesto: String) = this.puestoVenta = puesto

  def getFestival = festival
  def setFestival(fest: String) = this.festival = fest

  def entradas: java.util.List[Entrada] = {
    var entradas: ListBuffer[Entrada] = homeFestivales
    entradas = filtrarEntradas(entradas)
    //entradas = filtrarEntradasFestival(entradas)
    print(festival)
    print(puestoVenta)
    
    JavaConversions.asJavaList(entradas)

  }

  def filtrarEntradas(entradas: ListBuffer[Entrada]): ListBuffer[Entrada] = {
    if (puestoVenta == "" && festival == "") entradas
    else if (puestoVenta != "") homeFestivales.filter(entrada => entrada.puestoVenta.contains(puestoVenta))
    else if (festival != "") homeFestivales.filter(entrada => entrada.noche.fecha.contains(festival))
    else entradas //TODO el filter
  }
/*
  def filtrarEntradasFestival(entradas: ListBuffer[Entrada]): ListBuffer[Entrada] = {
    if (festival == "") entradas
    else entradas.filter(entrada => (entrada.noche.fecha == festival))
  }*/

  def clean = {
    puestoVenta = ""
    festival = ""
  }
}
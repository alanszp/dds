package home

import scala.collection.JavaConversions.asScalaBuffer
import org.uqbar.commons.utils.Observable
import recital.Banda
import recital.CategoriaPersona
import recital.Noche
import recital.Sector
import uqbar.arena.persistence.PersistentHome
import uqbar.arena.persistence.annotations.PersistentClass
import recital.Damas
import recital.Menor12
import recital.CategoriaBanda
import recital.Jubilado
import recital.Menor
import recital.RangoFilas
import recital.Mayor

@Observable
object HomeNoches extends PersistentHome[Noche] with Serializable {

  override def getEntityType(): Class[Noche] = classOf[Noche]
  override def createExample(): Noche = new Noche

  def create(pNombreNoche: String, pFecha: String, pBandas: java.util.List[Banda], pdescuentos: java.util.List[CategoriaPersona], pSectores: java.util.List[Sector]): Unit = {
    var noche = new Noche
    noche.setNombreNoche(pNombreNoche)
    noche.setBandas(pBandas)
    noche.setDescuentos(pdescuentos)
    noche.setSectores(pSectores)
    this.create(noche)
  }

  def noches: Seq[Noche] = allInstances

  def createIfNotExist(noche: Noche) = {
    if (this.get(noche) == null) {
      this.create(noche)
    }
  }
  
  def get(noche : Noche) = {
    noches.find(itemNoche => itemNoche.esIgual(noche)).getOrElse(null)
  }

  def populate = {
    var sectorA = new Sector("A")
    var sectorB = new Sector("B")
    var sectorC = new Sector("C")

    var fila1a10 = new RangoFilas(1, 10, 150, 20)
    var fila11a20 = new RangoFilas(11, 20, 70, 20)
    var fila21a30 = new RangoFilas(21, 30, 90, 20)

    sectorA.filas += fila1a10

    sectorB.filas += fila1a10
    sectorB.filas += fila11a20

    sectorC.filas += fila1a10
    sectorC.filas += fila11a20
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

    noche1.sectores += sectorA
    noche1.sectores += sectorB

    noche2.sectores += sectorA
    noche2.sectores += sectorB
    noche2.sectores += sectorC

    noche1.bandas += acdc
    noche1.bandas += wachiturros
    noche1.descuentos = noche1.descuentos union Set(jubilado, menor, mayor, damas, menorDe12)

    noche2.bandas += wachiturros
    noche2.descuentos = noche2.descuentos union Set(jubilado, menor, mayor, damas, menorDe12)

    createIfNotExist(noche1)
    createIfNotExist(noche2)
  }

}
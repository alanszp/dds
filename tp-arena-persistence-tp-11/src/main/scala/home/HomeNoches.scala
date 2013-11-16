package home

import scala.collection.JavaConversions.asScalaBuffer

import org.uqbar.commons.utils.Observable

import recital.Banda
import recital.CategoriaPersona
import recital.Noche
import recital.Sector
import uqbar.arena.persistence.PersistentHome
import uqbar.arena.persistence.annotations.PersistentClass

@Observable
object HomeNoches extends PersistentHome[Noche] with Serializable {
  
  override def getEntityType(): Class[Noche] = classOf[Noche]
  override def createExample(): Noche = new Noche
  
  def create(pNombreNoche: String, pFecha: String, pBandas: Set[Banda], pdescuentos: Set[CategoriaPersona], pSectores: Set[Sector]): Unit = {
  var noche = new Noche
  noche.setNombreNoche(pNombreNoche)
  noche.setBandas(pBandas)
  noche.setDescuentos(pdescuentos)
  noche.setSectores(pSectores)
  this.create(noche)
  } 
  
  def noches: Seq[Noche] = allInstances
}
package home

import org.uqbar.commons.utils.Observable

import recital.Noche
import uqbar.arena.persistence.PersistentHome

@Observable
class HomeNoches extends PersistentHome[Noche] with Serializable {
  
  override def getEntityType(): Class[Noche] = classOf[Noche]
  override def createExample(): Noche = new Noche
  
}
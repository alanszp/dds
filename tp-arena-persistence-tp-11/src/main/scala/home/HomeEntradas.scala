package home

import org.uqbar.commons.utils.Observable

import recital.Entrada
import uqbar.arena.persistence.PersistentHome

@Observable
class HomeEntradas extends PersistentHome[Entrada] with Serializable {
  
  override def getEntityType(): Class[Entrada] = classOf[Entrada]
  override def createExample(): Entrada = new Entrada
  
}
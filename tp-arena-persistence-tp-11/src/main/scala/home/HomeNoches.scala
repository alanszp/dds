package home

import org.uqbar.commons.model.CollectionBasedHome
import org.uqbar.commons.utils.Observable
import scala.collection.JavaConverters._
import scala.collection.JavaConversions._
import uqbar.arena.persistence.PersistentHome
import scala.collection.JavaConverters._
import recital._

@Observable
class HomeNoches extends PersistentHome[Noche] with Serializable {
  
  override def getEntityType(): Class[Noche] = classOf[Noche]
  override def createExample(): Noche = new Noche
  
}
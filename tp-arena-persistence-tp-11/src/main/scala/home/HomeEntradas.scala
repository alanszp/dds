package home

import org.uqbar.commons.utils.Observable

import recital.Entrada
import recital.Banda
import recital.CategoriaPersona
import recital.Noche
import recital.Sector
import uqbar.arena.persistence.PersistentHome

@Observable
object HomeEntradas extends PersistentHome[Entrada] with Serializable {
  
  override def getEntityType(): Class[Entrada] = classOf[Entrada]
  override def createExample(): Entrada = new Entrada
  
  def create(pSector: Sector, pNoche: Noche, pCategoria:CategoriaPersona, pFila: Int, pAsiento:Int, pCliente:String, pPuestoVenta:String): Unit = {
  var entrada = new Entrada
  entrada.setPuestoVenta(pPuestoVenta)
  entrada.setCliente(pCliente)
  entrada.setFila(pFila)
  entrada.setCategoriaPersona(pCategoria)
  entrada.setNoche(pNoche)
  entrada.setSector(pSector)
  entrada.setAsiento(pFila)
  this.create(entrada)
  } 
  
  def todasLasEntradas:  java.util.List[recital.Entrada] = {
	searchByExample(new Entrada())
  }
  
}
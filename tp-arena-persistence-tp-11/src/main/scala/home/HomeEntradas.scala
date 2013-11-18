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
  
  def entradas: java.util.List[recital.Entrada] = allInstances
  
  def filtrarPorCliente(cliente: String): java.util.List[recital.Entrada] = {
    val entrada = new Entrada()
    entrada.cliente = cliente
	searchByExample(entrada)
  }
  
  def filtrarPorNoche(noche: String): java.util.List[recital.Entrada] = {
    val entrada = new Entrada()
    val nochee = new Noche()
    nochee.nombreNoche = noche
    entrada.noche = nochee
	searchByExample(entrada)
  }
  
}
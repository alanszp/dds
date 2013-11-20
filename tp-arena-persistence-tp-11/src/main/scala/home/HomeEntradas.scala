package home

import org.uqbar.commons.utils.Observable
import recital.Entrada
import recital.Banda
import recital.CategoriaPersona
import recital.Noche
import recital.Sector
import uqbar.arena.persistence.PersistentHome
import org.uqbar.commons.model.UserException


@Observable
object HomeEntradas extends PersistentHome[Entrada] with Serializable {

  override def getEntityType(): Class[Entrada] = classOf[Entrada]
  override def createExample(): Entrada = new Entrada

  def create(pSector: Sector, pNoche: Noche, pCategoria: CategoriaPersona, pFila: Int, pAsiento: Int, pCliente: String, pPuestoVenta: String): Unit = {
    var entrada = new Entrada
    entrada.setPuestoVenta(pPuestoVenta)
    entrada.setCliente(pCliente)
    entrada.setFila(pFila)
    entrada.setCategoriaPersona(pCategoria)
    entrada.setNoche(pNoche)
    entrada.setSector(pSector)
    entrada.setAsiento(pAsiento)
    entrada.validarEntrada
    if (this.get(entrada) != null) {
      throw new UserException("Ya existe la entrada`")
    }
    this.create(entrada)
  }

  def entradas: java.util.List[recital.Entrada] = allInstances

  def createIfNotExist(entrada: Entrada) = {
    if (this.get(entrada) == null) {
      this.create(entrada)
    }
  }

  def get(entrada: Entrada): Entrada = {
    var iterator = entradas.iterator()
    var elem: Entrada = null
    while (iterator.hasNext()) {
      elem = iterator.next()
      if (entrada.sosOLaTenes(elem)) {
        return elem
      }
    }
    return null
  }
  
  def deleteAll = {
    var iterator = entradas.iterator()
    var elem : Noche = null
    while (iterator.hasNext()) {
      delete(iterator.next())
    }
  }
  
  def searchClienteYNoche(cliente:String, noche:String) = {
    var entrada = new Entrada()
    entrada.setCliente(cliente)
    entrada.setNoche(HomeNoches.getByFecha(noche))
    searchByExample(entrada)
  }
}

package appmodel

import scala.collection.JavaConversions
import scala.collection.mutable.ListBuffer
import recital.Banda
import recital.CategoriaBanda
import recital.CoreDeVentas
import recital.Damas
import recital.Entrada
import recital.Jubilado
import recital.Mayor
import recital.Menor
import recital.Menor12
import recital.Noche
import recital.RangoFilas
import recital.Sector
import java.util.ArrayList
import recital.CategoriaPersona
import home.HomeEntradas


@org.uqbar.commons.utils.Observable
class VenderEntradaAppModel(var listModel : ListadorEntrada) extends Serializable {
	
	var _nocheRecital : Noche = _
	var nombreCliente : String = _
    var apellidoCliente : String = _
    var categoriaCliente : CategoriaPersona = _
    var sector : Sector = _
    var fila : Int = _
    var asiento : Int = _
    
    var coreVentas = listModel.coreVentas
    
    var categoriasList : java.util.List[CategoriaPersona] = _
    var sectoresList : java.util.List[Sector] = _
    

    def nocheRecital_=(noche : Noche) = {
	  _nocheRecital = noche
	  actualizarCategoriasList
	  actualizarSectoresList
	}
	
	def nocheRecital = _nocheRecital
    
	def venderEntrada = {
	  	HomeEntradas.create(sector, nocheRecital, categoriaCliente, fila, asiento,nombreCliente, "Abasto")
	    var entradaNueva = new Entrada(sector, nocheRecital, categoriaCliente, fila, asiento, nombreCliente, "Abasto")
	    coreVentas.venderEntrada(entradaNueva)
	    listModel.search
	}
	
	def categorias : ListBuffer[CategoriaPersona] = {
	  traerLista(nocheRecital.descuentos)
	}
	
	def sectores : ListBuffer[Sector] = {
	  traerLista(nocheRecital.sectores)
	}
	
	def actualizarSectoresList = {
	  sectoresList = JavaConversions.asJavaList(sectores)
	}
	 
	def actualizarCategoriasList = {
	  categoriasList = JavaConversions.asJavaList(categorias)
	}
	
	def nochesList = JavaConversions.asJavaSet(coreVentas.noches)
	
	def setToBuffer[T](set : Set[T]) : ListBuffer[T] = {
	  var lista: ListBuffer[T] = ListBuffer()
	  set.foreach(entrada => lista += entrada)
	  lista
	}
  
	def traerLista[T](lista : Set[T]): ListBuffer[T] = {	  
	  if (nocheRecital == null)
	  	return ListBuffer()
	  setToBuffer[T](lista)	  
	}

}
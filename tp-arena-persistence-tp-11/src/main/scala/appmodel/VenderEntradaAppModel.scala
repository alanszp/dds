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
import home.HomeNoches


@org.uqbar.commons.utils.Observable
class VenderEntradaAppModel(var listEntradaModel : ListadorEntrada) extends Serializable {
	
	var _nocheRecital : Noche = _
	var nombreCliente : String = _
    var apellidoCliente : String = _
    var categoriaCliente : CategoriaPersona = _
    var sector : Sector = _
    var fila : Int = _
    var asiento : Int = _
    
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
	    listEntradaModel.search
	}
	
	def actualizarCategoriasList = {
	  categoriasList = traerLista(nocheRecital.descuentos)
	}
	
	def actualizarSectoresList = {
	  sectoresList = traerLista(nocheRecital.sectores)
	}
	
	def nochesList = HomeNoches.noches
	
	def traerLista[T](lista : java.util.List[T]): java.util.List[T] = {	  
	  if (nocheRecital == null)
	  	return new java.util.ArrayList
	  lista	  
	}

}
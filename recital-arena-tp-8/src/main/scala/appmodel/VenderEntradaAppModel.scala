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


@org.uqbar.commons.utils.Observable
class VenderEntradaAppModel extends Serializable {
	
	
	var coreVentas = new CoreDeVentas
	
	private var _nocheRecital : String = _
	private var _nombreCliente : String = _
    private var _apellidoCliente : String = _
    private var _categoriaCliente : String = _
    private var _sector : String = _
    private var _fila : String = _
    private var _asiento : String = _
	var entradaSeleccionada : Entrada = _

		//
		def nombreCliente_=(nombreCliente:String) = {
		  _nombreCliente = nombreCliente
		}
		def nombreCliente = _nombreCliente
		//
		def apellidoCliente_=(apellidoCliente:String) = {
		  _apellidoCliente = apellidoCliente
		}
		def apellidoCliente = _apellidoCliente
		//
		def nocheRecital_=(nocheRecital :String) = {
		  _nocheRecital = nocheRecital
		
		}
		def nocheRecital = _nocheRecital
		//
		def categoriaCliente_=(categoriaCliente :String) = {
		  _categoriaCliente = categoriaCliente		
		}
		
		def categoriaCliente = _categoriaCliente
		//
		def sector_=(sector :String) = {
		  _sector = sector		
		}
		
		def sector = _sector
		//
		def fila_=(fila:String) = {
		  _fila=fila
		
		}
		def fila = _fila
		//
		def asiento_=(asiento:String) = {
		  _asiento = asiento
		
		}
		def asiento = _asiento
		
	def venderEntrada {
		
		coreVentas.venderEntrada(entradaSeleccionada)

	}

}
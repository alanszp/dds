package appmodel.webapp

import recital._
import scala.collection.JavaConversions
import java.util.List
import scala.collection.mutable.ListBuffer


class HomeBandas {
	
	var core : CoreDeVentas = new CoreDeVentas
	var nombreBanda = ""
	this.populate
	
	def populate= {
	  var jubilado = new Jubilado(0.15)
	  var menor = new Menor(10,0.2)
	  var mayor = new Mayor
	  var damas = new Damas(0.2)
	  var menor12 = new Menor12(0.5)
		
	  var sectorA = new Sector("A")
		
	  var fila1a10 = new RangoFilas(1, 10, 150, 20)
	  var fila11a20 = new RangoFilas(11, 20, 70, 20)
		
	  sectorA.filas += fila1a10
	  sectorA.filas += fila11a20
			
	  var noche1 = new Noche("25/12/13")
	  var noche2 = new Noche("26/12/13")
	  
	  var categoria_nacionalPocoReconocida = new CategoriaBanda("Nacional Poco Reconocida", 0)
	  var categoria_nacionalReconocida = new CategoriaBanda("Nacional Reconocida", 50)
	  var categoria_nacionalReconocidaInternacionalmente = new CategoriaBanda("Nacional Reconocida Internacionalmente", 100)
	  var categoria_internacional = new CategoriaBanda("Internacional", 200)
	  
	  var acdc = new Banda("AC/DC", categoria_internacional)
	  var wachiturros = new Banda("Wachiturros", categoria_nacionalPocoReconocida)
	  var pinpinela = new Banda("Los Pinpinela", categoria_nacionalReconocida)
	  
	  noche1.bandas += acdc
	  noche1.bandas += wachiturros
	  noche1.descuentos = noche1.descuentos union Set(jubilado, menor, mayor, damas, menor12)
	  
	  noche2.bandas += pinpinela
	  noche2.descuentos = noche2.descuentos union Set(jubilado, menor, mayor, damas, menor12)
	 
	  core.noches += noche1
	  core.noches += noche2
	}
	
	def bandas : java.util.List[Banda] = {
		  JavaConversions.asJavaList(filteredBandas(nombreBanda))
		  
	}
	
	def filteredBandas(nombreBanda:String) : ListBuffer[Banda]= {
	  if (nombreBanda== "") {
	    return todasLasBandas
	  }
	  
	  todasLasBandas.filter(banda => banda.nombre.toLowerCase().contains(nombreBanda.toLowerCase()))
	}
	
	def todasLasBandas : ListBuffer[Banda] = {
	  var lista : ListBuffer[Banda] = ListBuffer()  
	  core.noches.flatMap(noches => noches.bandas).foreach(banda => lista+=banda) 
	  lista
	}
}
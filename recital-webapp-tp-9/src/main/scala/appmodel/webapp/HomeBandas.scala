package appmodel.webapp

import recital._
import scala.collection.JavaConversions
import java.util.List


class HomeBandas {
	
	var homeBandas : Set[Banda]= Set() 
	var nombreBanda = ""
	this.populate
	
	def populate : Unit= {
	  var categoria_nacionalPocoReconocida = new CategoriaBanda("Nacional Poco Reconocida", 0)
	  var categoria_nacionalReconocida = new CategoriaBanda("Nacional Reconocida", 50)
	  var categoria_nacionalReconocidaInternacionalmente = new CategoriaBanda("Nacional Reconocida Internacionalmente", 100)
	  var categoria_internacional = new CategoriaBanda("Internacional", 200)
	  
	  var acdc = new Banda("AC/DC", categoria_internacional)
	  var wachiturros = new Banda("Wachiturros", categoria_nacionalPocoReconocida)
	  var pinpinela = new Banda("Los Pinpinela", categoria_nacionalReconocida)
	 
	  homeBandas += acdc
	  homeBandas += wachiturros 
	  homeBandas += pinpinela
	}
	
	def getBandas = {
		  JavaConversions.asJavaSet(filteredBandas(nombreBanda))
		  
	}
	
	def filteredBandas(nombreBanda:String) : Set[Banda]= {
	  if (nombreBanda== "") {
	    return homeBandas
	  }
	  
	  homeBandas.filter(banda => banda.nombre.contains(nombreBanda))
	}
	
	def getNombreBanda = nombreBanda
	def setNombreBanda(nombre:String) = this.nombreBanda = nombre
}
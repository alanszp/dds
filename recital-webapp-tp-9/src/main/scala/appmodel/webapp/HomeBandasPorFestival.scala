package appmodel.webapp

import recital._
import scala.collection.JavaConversions
import java.util.List
import scala.collection.mutable.ListBuffer


/*class HomeBandasPorFestival extends AbstractModel {
	
	var core : CoreDeVentas = new CoreDeVentas
	var buscadorFestival = ""
	var buscadorCliente = ""
	this.populate
	
	def populate= {
	  var jubilado = new Jubilado(0.2)
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
	  
	  var rolling = new Banda("The Rolling Stones", categoria_internacional)
	  var u2 = new Banda("U2", categoria_internacional)
	  var Aha = new Banda("A-ha", categoria_internacional)
	  var bandana = new Banda("Las Bandana", categoria_nacionalPocoReconocida)
	  var ketchup = new Banda("Las Ketchup", categoria_nacionalPocoReconocida)
	  var pimpinela = new Banda("Los Pimpinela", categoria_nacionalReconocida)
	  var fabianacantilo = new Banda("Fabiana Cantilo", categoria_nacionalReconocida)
	  
	  noche1.bandas += rolling
	  noche1.bandas += u2
	  noche1.bandas += ketchup
	  noche1.descuentos = noche1.descuentos union Set(jubilado, menor, mayor, damas, menor12)
	  
	  noche2.bandas += pimpinela
	  noche2.bandas += fabianacantilo
	  noche2.bandas += Aha
	  noche2.bandas += bandana
	  noche2.descuentos = noche2.descuentos union Set(jubilado, menor, mayor, damas, menor12)
	 
	  core.noches += noche1
	  core.noches += noche2
	}
	
	def bandas : java.util.List[Banda] = {
	  JavaConversions.asJavaList(filteredBandas(buscadorCliente, buscadorFestival))
		  
	}
	
	def filteredBandas(nombreCliente:String, nombreFestival:String) : ListBuffer[Banda]= {
	  if ((buscadorFestival== "") && (buscadorCliente=="")) {
	    return todasLasBandas
	  }
	  else
	  {
		   /* if (buscadorFestival== ""){
		      
		    }
		    
		    if (buscadorCliente==""){
		      
		    } */
	  }
	
	  
	 // todasLasBandas.filter(banda => banda.nombre.toLowerCase().contains(nombreBanda.toLowerCase()))
	}
	
	//retorna todas las bandas que estan en TODAS las noches
	def todasLasBandas : ListBuffer[Banda] = {
	  var lista : ListBuffer[Banda] = ListBuffer()  
	  core.noches.flatMap(noches => noches.bandas).foreach(banda => lista+=banda) 
	  lista
	}
	
	//limpia forms
	def clean = {
	  buscadorCliente = ""
	  buscadorFestival = ""
	}*/
}
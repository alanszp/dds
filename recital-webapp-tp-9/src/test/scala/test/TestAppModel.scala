package test

import org.scalatest.junit._
import org.junit.Assert._
import org.junit.Test
import org.junit.Before
import org.junit.After
import appmodel.webapp._
import scala.collection.mutable.ListBuffer
import scala.collection.immutable.List

class TestAppModel extends AssertionsForJUnit {
	
	@Before
	var home = new HomeBandas
	
	 @Test
	  def testCorrectaInicializacionDeHomeBanda{
		 assertCantidadBandas("No tiene las tres bandas hardcodeadas", 3)
		 assertResultContains("No tiene todas las bandas instanciadas", ListBuffer("AC/DC","Wachiturros","Los Pinpinela"))
	  }
	
	 @Test
	  def testFiltroSinNombre{
		 home.nombreBanda = ""
		 assertCantidadBandas("No tiene las tres bandas hardcodeadas", 3)
		 assertResultContains("No tiene las tres bandas", ListBuffer("AC/DC","Wachiturros","Los Pinpinela"))
	  }
	@Test
	  def testFiltroConUnNombre{
		 home.setNombreBanda("AC")
		 assertCantidadBandas("No tiene las dos bandas que tendrian que salir", 2)
		 assertResultContains("No tiene se encuentra AC/DC y Wachiturros", ListBuffer("AC/DC","Wachiturros"))
	  }
	
	@Test
	  def testFiltroSinResultados{
		 home.setNombreBanda("ACBC")
		 assertCantidadBandas("Tendria que devolver 0 bandas", 0)
	  }
	 
	
	def assertResultContains(msg:String, lista:ListBuffer[String]) = {
	  assertEquals(msg, lista.sorted, this.home.filteredBandas(home.nombreBanda).map(banda => banda.nombre).sorted)
	}
	
	def assertCantidadBandas(msg:String, cantidad:Int) = assertEquals(msg, cantidad, home.getBandas.size)

}

package test

import org.scalatest.junit._
import org.junit.Assert._
import org.junit.Test
import org.junit.Before
import org.junit.After
import appmodel.webapp._

class TestAppModel extends AssertionsForJUnit {
  
 @Test
  def testCorrectaInicializacionDeHomeBanda{
	 var home = new HomeBandas
	 
	 assertTrue("No tiene las tres bandas hardcodeadas", home.homeBandas.size == 3)
  }

 @Test
  def testFiltroSinNombre{
	 var home = new HomeBandas
	 
	 assertTrue("No tiene las tres bandas hardcodeadas", home.getBandas.size == 3)
  }
@Test
  def testFiltroConUnNombre{
	 var home = new HomeBandas
	 home.setNombreBanda("AC")
	 assertTrue("No tiene las tres bandas hardcodeadas", home.getBandas.size == 2)
  }
 //Faltan mas. Cuando ande todo veo de agregar mas

}

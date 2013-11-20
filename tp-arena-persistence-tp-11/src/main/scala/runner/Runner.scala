package runner

import view.ListadorEntradaWindow
import org.uqbar.arena.Application
import uqbar.arena.persistence.Configuration
import home.HomeNoches
import home.HomeEntradas

object Runner extends Application with App {
	  def createMainWindow() = new ListadorEntradaWindow(this)
	  // Arena-persistence levanta los objetos persistidos
	  Configuration.configure()
//	  HomeNoches.deleteAll
//	  HomeEntradas.deleteAll
	  HomeNoches.populate
	 // Fin Arena-persistence
	  start()
}
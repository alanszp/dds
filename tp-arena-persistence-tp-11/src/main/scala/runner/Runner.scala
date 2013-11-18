package runner

import view.ListadorEntradaWindow
import org.uqbar.arena.Application
import uqbar.arena.persistence.Configuration
import home.HomeNoches

object Runner extends Application with App {
	  def createMainWindow() = new ListadorEntradaWindow(this)
	  // Arena-persistence levanta los objetos persistidos
	  Configuration.configure()
	  HomeNoches.populate
	 // Fin Arena-persistence
	  start()
}
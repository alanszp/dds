package runner

import view.ListadorEntradaWindow
import org.uqbar.arena.Application
import uqbar.arena.persistence.Configuration

object Runner extends Application with App {
	  def createMainWindow() = new ListadorEntradaWindow(this)
	  // Arena-persistence levanta los objetos persistidos
	  Configuration.configure()
	 // Fin Arena-persistence
	  start()
}
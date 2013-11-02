package runner

import view.ComprarEntradaWindow
import org.uqbar.arena.Application

object Runner extends Application with App {
	  def createMainWindow() = new ComprarEntradaWindow(this)
	  start()
}
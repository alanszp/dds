package runner

import view.ListadorEntradaWindow
import org.uqbar.arena.Application

object Runner extends Application with App {
	  def createMainWindow() = new ListadorEntradaWindow(this)
	  start()
}
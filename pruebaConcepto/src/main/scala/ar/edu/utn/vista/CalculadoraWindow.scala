package ar.edu.utn.vista

import org.uqbar.arena.actions.MessageSend
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.Window
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.Application

import java.awt.Color
import ar.edu.utn.dominio.Calculadora



class CalculadoraWindow(owner:WindowOwner) extends SimpleWindow[Calculadora](owner, new Calculadora()) {

	override def addActions(actionsPanel:Panel) = {
		new Button(actionsPanel) //
			.setCaption("+")
			.onClick(new MessageSend(this.getModelObject(), "sumar"))
			
		new Button(actionsPanel) //
			.setCaption("-")
			.onClick(new MessageSend(this.getModelObject(), "restar"))
		
		new Button(actionsPanel) //
			.setCaption("*")
			.onClick(new MessageSend(this.getModelObject(), "multiplicar"))
		
		new Button(actionsPanel) //
			.setCaption("/")
			.onClick(new MessageSend(this.getModelObject(), "dividir"))
			
		new Button(actionsPanel) //
			.setCaption("AC")
			.onClick(new MessageSend(this.getModelObject(), "reset"))
	}

	override def createFormPanel(mainPanel:Panel ) {
		this.setTitle("Calculadora Cientifica (?)")
		mainPanel.setLayout(new VerticalLayout())

		new Label(mainPanel).setText("Pantallita")

		new TextBox(mainPanel)
			.setWidth(100)
			.bindValueToProperty("operando")

		new Label(mainPanel)
			.setWidth(100)
			
			.bindValueToProperty("acumulador")

	}
	
	
}

object CalculadoraApplication extends Application with App {
	  def createMainWindow() = new CalculadoraWindow(this)
	  start()
	
}

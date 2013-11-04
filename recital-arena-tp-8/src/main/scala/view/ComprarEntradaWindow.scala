package view

import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.windows.SimpleWindow
import appmodel.ComprarEntradaAppModel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.actions.MessageSend
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.widgets.tables.Table
import recital.Entrada

class ComprarEntradaWindow(owner:WindowOwner) extends SimpleWindow[ComprarEntradaAppModel](owner, new ComprarEntradaAppModel())   {
	
	getModelObject.search
	
	override def createFormPanel(mainPanel:Panel ) {
		this.setTitle("Vender entradas!")
		
		mainPanel.setLayout(new VerticalLayout())

		var panelBusqueda = new Panel(mainPanel)
	    panelBusqueda.setLayout(new ColumnLayout(2))
	
	    //filtro fecha
	    var labelFecha = new Label(panelBusqueda)
	    labelFecha.setText("Fecha")
	    new TextBox(panelBusqueda).bindValueToProperty("nocheRecital")	     	
	
	    //filtro nombre
	    var labelNombre = new Label(panelBusqueda)
	    labelNombre.setText("Nombre del cliente")
	    new TextBox(panelBusqueda).bindValueToProperty("nombreCliente")


	}
	
	override def createMainTemplate(mainPanel: Panel) = {
	    this.setTitle("Vendedor de entradas")
	    this.setTaskDescription("Complete los campos para filtrar")
	
	    super.createMainTemplate(mainPanel)
	
	    this.createResultsGrid(mainPanel)
	    this.createGridActions(mainPanel)
	}
	
	override def addActions(actionsPanel: Panel) {
	    new Button(actionsPanel) //
	      .setCaption("Limpiar")
	      .onClick(new MessageSend(getModelObject, "clear"))
	
	    new Button(actionsPanel) //
	      .setCaption("Vender Entrada")
	      .onClick(new MessageSend(this, "venderEntrada"))
	}
	
	def venderEntrada() {
		//this.openDialog(new VenderEntradaWindow(this))
	  var ventana = new VenderEntradaWindow(this)
	  ventana.open()
	}
	
	def openDialog(dialog: Dialog[_]) {
	    dialog.onAccept(new MessageSend(getModelObject, "search"))
	    dialog.open
	 }
	
	def createResultsGrid(mainPanel: Panel) {
	    var table = new Table[Entrada](mainPanel, classOf[Entrada])
	    table.setHeigth(200)
	    table.setWidth(600)
	    table.bindItemsToProperty("listaEntradas")
	    table.bindValueToProperty("entradaSeleccionada")
	    this.setearColumnas(table)
	}
	
	def setearColumnas(table: Table[Entrada]) {
	    new Column[Entrada](table) //
	      .setTitle("Fecha")
	      .bindContentsToProperty("noche.fecha")
	
	    new Column[Entrada](table) //
	      .setTitle("Cliente")
	      .bindContentsToProperty("cliente")
	
	    new Column[Entrada](table)
	      .setTitle("Sector")
	      .bindContentsToProperty("sector.nombre")
	      
	    new Column[Entrada](table)
	      .setTitle("Fila")
	      .bindContentsToProperty("fila")
	      
	    new Column[Entrada](table)
	      .setTitle("Asiento")
	      .bindContentsToProperty("asiento")
	}
	
	 def createGridActions(mainPanel: Panel) {
		var actionsPanel = new Panel(mainPanel)
 		actionsPanel.setLayout(new HorizontalLayout)
 			
	    var remove = new Button(actionsPanel)
	      .setCaption("Anular")
	      .onClick(new MessageSend(getModelObject, "anularEntradaSeleccionada"))
	
	    // Deshabilitar los botones si no hay ningÃºn elemento seleccionado en la grilla.
	    var elementSelected = new NotNullObservable("entradaSeleccionada")
	    remove.bindEnabled(elementSelected)
	 }
	
}

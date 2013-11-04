package view

import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.windows.SimpleWindow
import appmodel.VenderEntradaAppModel
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

class VenderEntradaWindow(owner:WindowOwner) extends SimpleWindow[VenderEntradaAppModel](owner, new VenderEntradaAppModel()) {

  getModelObject.search
	
	override def createFormPanel(mainPanel:Panel ) {
		this.setTitle("Nueva Entrada")
		
		mainPanel.setLayout(new VerticalLayout())

		var panelVenta = new Panel(mainPanel)
	    panelVenta.setLayout(new ColumnLayout(2))
	
	    var textNombre = new TextBox(mainPanel)
		var textApellido = new TextBox(mainPanel)
	    var textNoche = new TextBox(mainPanel)
		var textCategoriaPersona = new TextBox(mainPanel)
		var textSector = new TextBox(mainPanel)
		var textFila = new TextBox(mainPanel)
		var textAsiento = new TextBox(mainPanel)
		
	
}
  

	override def createMainTemplate(mainPanel: Panel) = {
	    this.setTitle("Vendedor de entradas")
	    this.setTaskDescription("Complete los campos para vender la entrada")
	
	    super.createMainTemplate(mainPanel)
	
	   // this.createResultsGrid(mainPanel)
	  //  this.createGridActions(mainPanel)
	}
	
	override def addActions(actionsPanel: Panel) {
	   // new Button(actionsPanel) //
	   //   .setCaption("Limpiar")
	   //   .onClick(new MessageSend(getModelObject, "clear"))
	
	    new Button(actionsPanel) //
	      .setCaption("Vender Entrada")
	      .onClick(new MessageSend(this, "venderEntrada"))
	}
	
	def venderEntrada() {
		//ACCION QUE VENDA LA ENTRADA
	}
	
	def openDialog(dialog: Dialog[_]) {
	    dialog.onAccept(new MessageSend(getModelObject, "search"))
	    dialog.open
	 }
	
	/*def setearColumnas(table: Table[Entrada]) {
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
	}*/
	 
	
}
 
	
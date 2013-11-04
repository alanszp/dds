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
	
	override def createFormPanel(mainPanel:Panel ) {
		this.setTitle("Nueva Entrada")
		
		mainPanel.setLayout(new VerticalLayout())

		var panelVenta = new Panel(mainPanel)
	    panelVenta.setLayout(new ColumnLayout(2))
	
	    var labelNombre = new Label(panelVenta)
	    labelNombre.setText("Nombre del cliente")
	    var textNombre = new TextBox(panelVenta)
		//BINDEAR LAS PROPERTYS QUE FALTAN
		//textNombre.bindValueToProperty("nocheRecital")	 
		
	     var labelApe = new Label(panelVenta)
	    labelApe.setText("Apellido del cliente")
		var textApellido = new TextBox(panelVenta)
		
		 var labelNoche = new Label(panelVenta)
	    labelNoche.setText("Fecha de la noche")
	    var textNoche = new TextBox(panelVenta)
		
		 var labelCategoria = new Label(panelVenta)
	    labelCategoria.setText("Categoria de la persona")
		var textCategoriaPersona = new TextBox(panelVenta)
		
		 var labelSector = new Label(panelVenta)
	    labelSector.setText("Numero de Sector")
		var textSector = new TextBox(panelVenta)
		
		 var labelFila= new Label(panelVenta)
	    labelFila.setText("Numero de fila")
		var textFila = new TextBox(panelVenta)
		
		 var labelAsiento = new Label(panelVenta)
	    labelAsiento.setText("Numero de Asiento")
		var textAsiento = new TextBox(panelVenta)
		
	
}
  

	override def createMainTemplate(mainPanel: Panel) = {
	    this.setTitle("Vendedor de entradas")
	    this.setTaskDescription("Complete los campos para vender la entrada")
	
	    super.createMainTemplate(mainPanel)
	}
	
	override def addActions(actionsPanel: Panel) {
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
	
	 
	
}
 
	
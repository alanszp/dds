package view

import org.uqbar.arena.actions.MessageSend
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import appmodel.ComprarEntradaAppModel
import appmodel.VenderEntradaAppModel
import recital.Entrada
import appmodel.ComprarEntradaAppModel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.bindings.ObservableProperty
import org.uqbar.arena.bindings.PropertyAdapter

class VenderEntradaWindow(owner: ComprarEntradaWindow) extends SimpleWindow[ComprarEntradaAppModel](owner, owner.getModelObject()) {

  override def createFormPanel(mainPanel: Panel) {
    this.setTitle("Nueva Entrada")

    mainPanel.setLayout(new VerticalLayout())

    var panelVenta = new Panel(mainPanel)
    panelVenta.setLayout(new ColumnLayout(2))

    var labelNombre = new Label(panelVenta)
    labelNombre.setText("Nombre del cliente")
    var textNombre = new TextBox(panelVenta)
    textNombre.bindValueToProperty("nombreCliente")

    var labelApe = new Label(panelVenta)
    labelApe.setText("Apellido del cliente")
    var textApellido = new TextBox(panelVenta)
    textApellido.bindValueToProperty("apellidoCliente")

    var labelNoche = new Label(panelVenta)
    labelNoche.setText("Fecha de la noche")
    var selectorNoche = new Selector[Panel](panelVenta)
    selectorNoche.allowNull(false)
    selectorNoche.bindValueToProperty("noche")
    var propiedadSectorNoche = selectorNoche.bindItems(new ObservableProperty(getModelObject, "nochesList"))
  //  propiedadSectorNoche.setAdapter(new PropertyAdapter(classOf[Modelo], "descripcionEntera"))

    var labelCategoria = new Label(panelVenta)
    labelCategoria.setText("Categoria de la persona")
    var selectorCategoria = new Selector[Panel](panelVenta)
    selectorCategoria.allowNull(false)
    selectorCategoria.bindValueToProperty("categoriaCliente")
    var propiedadSectorCategoria = selectorCategoria.bindItems(new ObservableProperty(getModelObject, "categoriasList"))
  //  propiedadSectorCategoria.setAdapter(new PropertyAdapter(classOf[Modelo], "descripcionEntera"))

    //-------

    var labelSector = new Label(panelVenta)
    labelSector.setText("Numero de Sector")
    var selectorSector = new Selector[Panel](panelVenta)
    selectorSector.allowNull(false)
    selectorSector.bindValueToProperty("sector")
    var propiedadSectorSector = selectorSector.bindItems(new ObservableProperty(getModelObject, "sectoresList"))
    //propiedadSectorSector.setAdapter(new PropertyAdapter(classOf[Modelo], "sectoresMostrar"))

    var labelFila = new Label(panelVenta)
    labelFila.setText("Numero de fila")
    var textFila = new TextBox(panelVenta)
    textFila.bindValueToProperty("fila")

    var labelAsiento = new Label(panelVenta)
    labelAsiento.setText("Numero de Asiento")
    var textAsiento = new TextBox(panelVenta)
    textAsiento.bindValueToProperty("asiento")

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
      //.onClick()
  }

  def openDialog(dialog: Dialog[_]) {
    dialog.onAccept(new MessageSend(getModelObject, "search"))
    dialog.open
  }
  
  def venderEntrada = {
    getModelObject().venderEntrada
    getModelObject().limpiarCampos
    this.close()
  }

}
 
	
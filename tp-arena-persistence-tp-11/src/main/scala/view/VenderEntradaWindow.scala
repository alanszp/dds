package view

import org.uqbar.arena.actions.MessageSend
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.bindings.ObservableProperty
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.SimpleWindow

import appmodel.VenderEntradaAppModel

class VenderEntradaWindow(owner: ListadorEntradaWindow) extends SimpleWindow[VenderEntradaAppModel](owner, new VenderEntradaAppModel(owner.getModelObject)) {

  override def createFormPanel(mainPanel: Panel) {
    this.setTitle("Nueva Entrada")

    
    mainPanel.setLayout(new VerticalLayout())

    var panelVenta = new Panel(mainPanel)
    panelVenta.setLayout(new ColumnLayout(2))

    var labelNombre = new Label(panelVenta)
    labelNombre.setText("Nombre del cliente")
    var textNombre = new TextBox(panelVenta)
    textNombre.bindValueToProperty("nombreCliente")

    var labelNoche = new Label(panelVenta)
    labelNoche.setText("Fecha de la noche")
    var selectorNoche = new Selector[Panel](panelVenta)
    selectorNoche.allowNull(false)
    selectorNoche.setWidth(100)
    selectorNoche.bindValueToProperty("nocheRecital")
    var propiedadSectorNoche = selectorNoche.bindItems(new ObservableProperty(getModelObject, "nochesList"))
  //  propiedadSectorNoche.setAdapter(new PropertyAdapter(classOf[Modelo], "descripcionEntera"))

    var labelCategoria = new Label(panelVenta)
    labelCategoria.setText("Categoria de la persona")
    var selectorCategoria = new Selector[Panel](panelVenta)
    selectorCategoria.allowNull(false)
    selectorCategoria.setWidth(100)
    selectorCategoria.bindEnabled(new NotNullObservable("nocheRecital"))
    selectorCategoria.bindValueToProperty("categoriaCliente")
    selectorCategoria.bindItemsToProperty("categoriasList")
  //  propiedadSectorCategoria.setAdapter(new PropertyAdapter(classOf[Modelo], "descripcionEntera"))

    //-------

    var labelSector = new Label(panelVenta)
    labelSector.setText("Sector")
    var selectorSector = new Selector[Panel](panelVenta)
    selectorSector.allowNull(false)
    selectorSector.setWidth(100)
    selectorSector.bindEnabled(new NotNullObservable("nocheRecital"))
    selectorSector.bindValueToProperty("sector")
    selectorSector.bindItemsToProperty("sectoresList")
    //propiedadSectorSector.setAdapter(new PropertyAdapter(classOf[Modelo], "sectoresMostrar"))

    var labelFila = new Label(panelVenta)
    labelFila.setText("Numero de fila")
    var textFila = new TextBox(panelVenta)
    textFila.bindValueToProperty("fila")
    textFila.bindEnabled(new NotNullObservable("sector"))

    var labelAsiento = new Label(panelVenta)
    labelAsiento.setText("Numero de Asiento")
    var textAsiento = new TextBox(panelVenta)
    textAsiento.bindValueToProperty("asiento")
    textAsiento.bindEnabled(new NotNullObservable("sector"))
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

  def openDialog(dialog: Dialog[_]) {
    dialog.onAccept(new MessageSend(getModelObject, "search"))
    dialog.open
  }
  
  def venderEntrada = {
    getModelObject().venderEntrada
    this.close()
  }

}
 
	
package ui.webapp

import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.markup.html.form.AjaxButton
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.markup.html.list.ListItem
import org.apache.wicket.markup.html.list.PropertyListView
import org.apache.wicket.model.CompoundPropertyModel

import appmodel.webapp.HomeEntradas
import recital.Entrada

class HomeEntradsaPage extends WebPage {

	val buscadorCliente = new HomeEntradas
	
	val buscarFormCliente = new Form [HomeEntradas]("buscarPorClienteForm", new CompoundPropertyModel[HomeEntradas](buscadorCliente))
	addSearchFields(buscarFormCliente)
	addResults (buscarFormCliente)
	addActions(buscarFormCliente)
	add(buscarFormCliente)
	
	//campos con los que se hace la busqueda
	def addSearchFields(buscadorCliente: Form[HomeEntradas]) =
    buscadorCliente.add(new TextField[String]("nombreCliente"))
    
    def addResults(buscarForm: Form[HomeEntradas]) =
    buscarForm.add(new PropertyListView[Entrada]("entradas") {
      override def populateItem(item: ListItem[Entrada]) = item.add(
          new Label("cliente"),
          new Label("sector"),
          new Label("fecha"),
          new Label("fila"),
          new Label("asiento")
    )
    
    })
    
    //botones
    def addActions(form: Form[HomeEntradas]) = { form.add(
      new AjaxButton("buscar") {
        override def onSubmit(target: AjaxRequestTarget, form: Form[_]) = {
          target.addComponent(buscarFormCliente)
        }

        override def onError(target: AjaxRequestTarget, form: Form[_]) = {}
      })
    
    form.add(
      new AjaxButton("limpiar") {
        override def onSubmit(target: AjaxRequestTarget, form: Form[_]) = {
          buscadorCliente.nombreCliente = ""
          buscadorCliente.fechaDesde = ""
          buscadorCliente.fechaHasta = "" 
          target.addComponent(buscarFormCliente)
        }

        override def onError(target: AjaxRequestTarget, form: Form[_]) = {}
      })
  }
}
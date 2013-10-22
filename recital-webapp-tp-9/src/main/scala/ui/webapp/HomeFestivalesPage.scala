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

import appmodel.webapp.HomeFestivales
import recital._

class HomeFestivalesPage extends WebPage {
  val model = new HomeFestivales

  val buscarForm = new Form[HomeFestivales]("buscarPuestoForm", new CompoundPropertyModel[HomeFestivales](model))
  addSearchFields(buscarForm)
  addResults(buscarForm)
  addActions(buscarForm)
  add(buscarForm)

  //campos con los que se hace la busqueda
  def addSearchFields(buscadorFestival: Form[HomeFestivales]) =
    buscadorFestival.add(new TextField[String]("puestoVenta"))

  def addResults(buscarForm: Form[HomeFestivales]) =
    buscarForm.add(new PropertyListView[Entrada]("entradas") {
      override def populateItem(item: ListItem[Entrada]) = item.add(
        new Label("puesto"),
        new Label("noche.fecha"),
        new Label("sector"),
        new Label("fila"),
        new Label("asiento"))

    })

  //botones
  def addActions(form: Form[HomeFestivales]) = {
    form.add(
      new AjaxButton("buscar") {
        override def onSubmit(target: AjaxRequestTarget, form: Form[_]) = {
          target.addComponent(buscarForm)
        }

        override def onError(target: AjaxRequestTarget, form: Form[_]) = {}
      })

    form.add(
      new AjaxButton("limpiar") {
        override def onSubmit(target: AjaxRequestTarget, form: Form[_]) = {
          model.puestoVenta = ""
          model.festival = ""
          target.addComponent(buscarForm)
        }

        override def onError(target: AjaxRequestTarget, form: Form[_]) = {}
      })
  }
}
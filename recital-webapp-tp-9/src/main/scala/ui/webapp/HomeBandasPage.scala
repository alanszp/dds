package ui.webapp

import appmodel.webapp._
import recital.Banda

import org.apache.wicket.markup.html.list.PropertyListView
import org.apache.wicket.markup.html.list.ListItem
import org.apache.wicket.ajax.markup.html.form.AjaxButton
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.markup.html.link.Link
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.markup.html.basic.Label

class HomeBandasPage extends WebPage {
	var model = new HomeBandas
	
	var buscarForm = new Form[HomeBandas]("buscarBandasForm", new CompoundPropertyModel[HomeBandas](model))
	addSearchFields(buscarForm)
	addResults(buscarForm)
	addActions(buscarForm)
	add(buscarForm)
	
	
	def addSearchFields(buscarForm: Form[HomeBandas]) = {
	  buscarForm.add(new TextField("nombreBanda"))
	} 
	
	def addResults(filtroForm:Form[HomeBandas]) = 
	  buscarForm.add(new PropertyListView[Banda]("bandas") {
		  override def populateItem(item: ListItem[Banda]) = item.add(new Label("nombre"))
    })
    
	
	def addActions(form: Form[HomeBandas]) = {
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
          model.nombreBanda = ""
          target.addComponent(buscarForm)
        }

        override def onError(target: AjaxRequestTarget, form: Form[_]) = {}
      })
  }
}
package ui.webapp

import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.list.PropertyListView
import org.apache.wicket.markup.html.list.ListItem
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.ajax.markup.html.form.AjaxButton
import appmodel.webapp.HomeBandas
import org.apache.wicket.ajax.AjaxRequestTarget
import appmodel.webapp.AbstractModel
import org.apache.wicket.model.CompoundPropertyModel

class FormBuilder {
  
  var model : AbstractModel = _
  var form : Form[_] = _

  def setForm[T:Manifest](idForm : String) = {
    this.form = new Form[T](idForm, new CompoundPropertyModel[T](model))
  }

  def setModel(model : AbstractModel) = this.model = model
  
  def setResult[T:Manifest](id:String,  columnas : List[String]) = {
		form.add(new PropertyListView[T](id) {
			override def populateItem(item: ListItem[T]) = columnas.foreach(idColumna => item.add(new Label(idColumna)) )
		})
	  }

  def setSearchFields(lista : List[String]) = {
    lista.foreach(idField => form.add(new TextField(idField)) )
  }
	
   
  	
	def setActions(search:String, clean:String) = {
    form.add(
      new AjaxButton(search) {
        override def onSubmit(target: AjaxRequestTarget, form: Form[_]) = {
          target.addComponent(form)
        }

        override def onError(target: AjaxRequestTarget, form: Form[_]) = {}
      })
    
    form.add(
      new AjaxButton(clean) {
        override def onSubmit(target: AjaxRequestTarget, form: Form[_]) = {
          model.clean
          target.addComponent(form)
        }

        override def onError(target: AjaxRequestTarget, form: Form[_]) = {}
      })
  }
    
	def build = this.form

}
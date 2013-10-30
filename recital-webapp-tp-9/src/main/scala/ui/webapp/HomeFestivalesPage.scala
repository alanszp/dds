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
	 var formBuilder = new FormBuilder
  //Setear el modelo --> Pasarle una instancia	
	formBuilder.setModel(new HomeFestivales)
	
	//Setear el formulario a usar (Hay que pasarle el tipo del modelo, para que pueda crear el form)
	formBuilder.setForm[HomeFestivales]("buscarPuestoForm")
	
	//Setear los campos de busqueda que va a tener el form (Con una lista)
	formBuilder.setSearchFields(List("puestoVenta", "festival"))
	
	//Setear el id de la tabla general y cada columna con una lista (El tipo que se le pasa es de cada fila que se va a mostrar)
	formBuilder.setResult[Entrada]("entradas", List("puestoVenta", "noche.fecha", "sector.nombre", "fila", "asiento", "cliente"))

	//Setear nombre del boton de accion. Buscar y limpiar.
	formBuilder.setActions("buscar", "limpiar")
	
	//Especie de build. Agrega el formulario a la pagina.
	add(formBuilder.build)
}
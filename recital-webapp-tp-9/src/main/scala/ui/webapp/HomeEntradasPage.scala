package ui.webapp

import appmodel.webapp.HomeBandas
import recital.Banda
import appmodel.webapp.HomeEntradas
import recital.Entrada
import org.apache.wicket.markup.html.WebPage

class HomeEntradasPage extends WebPage { 
	
  var formBuilder = new FormBuilder
  //Setear el modelo --> Pasarle una instancia	
	formBuilder.setModel(new HomeEntradas)
	
	//Setear el formulario a usar (Hay que pasarle el tipo del modelo, para que pueda crear el form)
	formBuilder.setForm[HomeEntradas]("buscarPorClienteForm")
	
	//Setear los campos de busqueda que va a tener el form (Con una lista)
	formBuilder.setSearchFields(List("nombreCliente", "fechaDesde", "fechaHasta"))
	
	//Setear el id de la tabla general y cada columna con una lista (El tipo que se le pasa es de cada fila que se va a mostrar)
	formBuilder.setResult[Entrada]("entradas", List("cliente", "sector.nombre", "noche.fecha", "fila", "asiento"))

	//Setear nombre del boton de accion. Buscar y limpiar.
	formBuilder.setActions("buscar", "limpiar")
	
	//Especie de build. Agrega el formulario a la pagina.
	add(formBuilder.build)
}
//    
//    //botones
//    def addActions(form: Form[HomeEntradas]) = { form.add(
//      new AjaxButton("buscar") {
//        override def onSubmit(target: AjaxRequestTarget, form: Form[_]) = {
//          target.addComponent(buscarFormCliente)
//        }
//
//        override def onError(target: AjaxRequestTarget, form: Form[_]) = {}
//      })
//    
//    form.add(
//      new AjaxButton("limpiar") {
//        override def onSubmit(target: AjaxRequestTarget, form: Form[_]) = {
//          buscadorCliente.nombreCliente = ""
//          buscadorCliente.fechaDesde = ""
//          buscadorCliente.fechaHasta = "" 
//          target.addComponent(buscarFormCliente)
//        }
//
//        override def onError(target: AjaxRequestTarget, form: Form[_]) = {}
//      })
//  }
//}
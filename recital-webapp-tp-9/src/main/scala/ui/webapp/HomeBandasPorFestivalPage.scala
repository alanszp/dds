package ui.webapp

import appmodel.webapp.HomeBandasPorFestival
import recital.Noche
import appmodel.webapp.HomeBandasPorFestival
import org.apache.wicket.markup.html.WebPage

class HomeBandasPorFestivalPage extends WebPage {
  
  var formBuilder = new FormBuilder
  
	//Setear el modelo --> Pasarle una instancia	
	formBuilder.setModel(new HomeBandasPorFestival)
	
	//Setear el formulario a usar (Hay que pasarle el tipo del modelo, para que pueda crear el form)
	formBuilder.setForm[HomeBandasPorFestival]("buscarBandasPorFestivalForm")
	
	//Setear los campos de busqueda que va a tener el form (Con una lista)
	formBuilder.setSearchFields(List("nombreFestival"))
	
	//Setear el id de la tabla general y cada columna con una lista (El tipo que se le pasa es de cada fila que se va a mostrar)
	//setResult[Banda]("bandas", List("nombre", "categoria.tipo", "categoria.precioExtra"))
	formBuilder.setResult[Noche]("festivales", List("nombre_cliente", "entrada", "nombre_festival", "nombre_banda"))
	
	//Setear nombre del boton de accion. Buscar y limpiar.
	formBuilder.setActions("buscar", "limpiar")
	
	//Build. Agrega el formulario a la pagina.
	add(formBuilder.build)
} 
package ui.webapp

import appmodel.webapp.HomeBandasPorFestival
import recital.Banda
import appmodel.webapp.HomeBandasPorFestival
import org.apache.wicket.markup.html.WebPage

class HomeBandasPorFestivalPage extends WebPage {
  
  //Mediante la clase FormBuilder, creo un nuevo form llamado "formBuilder"
  var formBuilder = new FormBuilder
  
  //Le seteo un modelo de datos al form recien creado--> la instancia de la clase (.scala) que quiera representar
  formBuilder.setModel(new HomeBandasPorFestival)
	
  //Le seteo el formulario a usar al form creado-->Le paso el tipo del modelo (.scala) y con el id que le puse en el .html
  formBuilder.setForm[HomeBandasPorFestival]("buscarBandasPorFestivalForm")
	
  //Setear los campos de busqueda que va a tener el form (Con una lista)
  formBuilder.setSearchFields(List("buscadorFestival", "buscadorCliente"))
	
  //Setear el id de la tabla general y cada columna con una lista (El tipo que se le pasa es de cada fila que se va a mostrar)
	formBuilder.setResult[Banda]("bandas", List("nombre", "categoria.tipo", "categoria.precioExtra"))
	
	//Setear nombre del boton de accion. Buscar y limpiar.
	formBuilder.setActions("buscar", "limpiar")
	
	//Build. Agrega el formulario a la pagina.
	add(formBuilder.build)
} 
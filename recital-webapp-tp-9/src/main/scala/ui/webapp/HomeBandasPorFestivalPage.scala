package ui.webapp

import appmodel.webapp.HomeBandasPorFestival
import recital.Noche //vendria a ser noche=festival, es lo mismo.
import appmodel.webapp.HomeBandasPorFestival

class HomeBandasPorFestivalPage extends AbstractHome {
	//Setear el modelo --> Pasarle una instancia	
	setModel(new HomeBandasPorFestival)
	
	//Setear el formulario a usar (Hay que pasarle el tipo del modelo, para que pueda crear el form)
	setForm[HomeBandasPorFestival]("buscarBandasPorFestivalForm")
	
	//Setear los campos de busqueda que va a tener el form (Con una lista)
	setSearchFields(List("nombreFestival"))
	
	//Setear el id de la tabla general y cada columna con una lista (El tipo que se le pasa es de cada fila que se va a mostrar)
	//setResult[Banda]("bandas", List("nombre", "categoria.tipo", "categoria.precioExtra"))
	setResult[Noche]("festivales", List("cliente", "entrada" "categoria.tipo", "categoria.precioExtra"))
	
	//Setear nombre del boton de accion. Buscar y limpiar.
	setActions("buscar", "limpiar")
	
	//Especie de build. Agrega el formulario a la pagina.
	start
} 
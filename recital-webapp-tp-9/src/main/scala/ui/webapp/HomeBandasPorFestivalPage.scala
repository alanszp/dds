package ui.webapp

import appmodel.webapp.HomeBandasPorFestival
import recital.Banda

class HomeBandasPorFestivalPage extends AbstractHome {
	//Setear el modelo --> Pasarle una instancia	
	setModel(new HomeBandas)
	
	//Setear el formulario a usar (Hay que pasarle el tipo del modelo, para que pueda crear el form)
	setForm[HomeBandas]("buscarBandasForm")
	
	//Setear los campos de busqueda que va a tener el form (Con una lista)
	setSearchFields(List("nombreBanda"))
	
	//Setear el id de la tabla general y cada columna con una lista (El tipo que se le pasa es de cada fila que se va a mostrar)
	setResult[Banda]("bandas", List("nombre", "categoria.tipo", "categoria.precioExtra"))

	//Setear nombre del boton de accion. Buscar y limpiar.
	setActions("buscar", "limpiar")
	
	//Especie de build. Agrega el formulario a la pagina.
	start
} 
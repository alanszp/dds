package ui.webapp

import appmodel.webapp.HomeBandas
import recital.Banda
import org.apache.wicket.markup.html.WebPage

class HomeBandasPage extends WebPage {
  def buildForm = {
    var formBuilder = new FormBuilder
    //Setear el modelo --> Pasarle una instancia	
    formBuilder.setModel(new HomeBandas)

    //Setear el formulario a usar (Hay que pasarle el tipo del modelo, para que pueda crear el form)
    formBuilder.setForm[HomeBandas]("buscarBandasForm")

    //Setear los campos de busqueda que va a tener el form (Con una lista)
    formBuilder.setSearchFields(List("nombreBanda"))

    //Setear el id de la tabla general y cada columna con una lista (El tipo que se le pasa es de cada fila que se va a mostrar)
    formBuilder.setResult[Banda]("bandas", List("nombre", "categoria.tipo", "categoria.precioExtra"))

    //Setear nombre del boton de accion. Buscar y limpiar.
    formBuilder.setActions("buscar", "limpiar")

    //Build. Agrega el formulario a la pagina.
    formBuilder.build
  }

  add(buildForm)
} 
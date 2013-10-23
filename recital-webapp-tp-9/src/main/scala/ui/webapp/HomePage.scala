package ui.webapp

import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Date
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.link.Link
import org.apache.wicket.markup.html.list.ListItem
import org.apache.wicket.markup.html.list.PropertyListView
import org.apache.wicket.request.mapper.parameter.PageParameters
import scala.collection.JavaConversions._
import org.apache.wicket.Page
import scala.beans.BeanProperty

class MenuAction(@BeanProperty val linkName: String, val responsePage: Class[_ <: Page]) extends Serializable

class HomePage extends WebPage {

    add(new PropertyListView[MenuAction]("links", opciones) {
      override def populateItem(item: ListItem[MenuAction]) = {
        val link = new Link[Object]("link") {
          override def onClick = setResponsePage(item.getModelObject.responsePage)
        }
        link.add(new Label("linkName"))
        item.add(link)
      }
    })

  def opciones = List(
    new MenuAction("Tomas Gropper - Integrante 1", classOf[HomeFestivalesPage]),
    new MenuAction("Uriel Petasny - Integrante 2", classOf[HomeEntradasPage]),
    new MenuAction("Alan Szpigiel - Integrante 3", classOf[HomeBandasPage]))
    //new MenuAction("Guido Kuznicki - Integrante 4", classOf[HomeBandasPorFestivalPage]))
}

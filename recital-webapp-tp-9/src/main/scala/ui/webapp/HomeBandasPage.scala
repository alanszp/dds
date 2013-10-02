package ui.webapp

import org.apache.wicket.markup.html._;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.Component;

import appmodel.webapp._;

class HomeBandasPage extends WebPage {
	var	serialVersionUID = 1L;
	var model = new HomeBandas
	var resultados:Component = _
	
	def addSearchFields(filtroForm: Form[HomeBandas]) = {
	  filtroForm.add(new TextField("nombre"))
	} 
	
	def addResults(filtroForm:Form[HomeBandas]) = {
	  createResultados
	  filtroForm.add(resultados)
	}
	
	def createResultados = {
	  var panel:WebMarkupContainer = new WebMarkupContainer("resultados")
	  panel.setOutputMarkupId(true);
	}
}

/*
 * 
 * new Form(idWicketDel form)
 * 
 * ListView
 * 
 * 
 */



/*
public class ListadoSociosPage extends AbstractWebPage<ListadoSocios> {
	private Component resultSection;

	public ListadoSociosPage() {
		super(new ListadoSocios());
		
		Form<ListadoSocios> buscarForm = this.createForm("buscarForm");
		this.addSearchFields(buscarForm);
		this.addResults(buscarForm);
		this.addButtons(buscarForm);
		
		this.add(buscarForm);
	}

	/**
	 * Crea y agrega los campos con los que se hace la busqueda. Estos controles se bindean automaticamente
	 * con las properties del modelo del form, que es un objeto de tipo {@link ListadoSocios}.
	 */
	protected void addSearchFields(Form<ListadoSocios> buscarForm) {
		buscarForm.add(new TextField<String>("nombre")); // edita la property 'nombre' de ListadoSocios.
		buscarForm.add(new TextField<String>("direccion")); // edita la property 'direccion' de ListadoSocios.
	}


	protected void addResults(Form<ListadoSocios> buscarForm) {
		this.resultSection = this.createResultsSection();
		buscarForm.add(this.resultSection);
	}

	protected WebMarkupContainer createResultsSection() {
		WebMarkupContainer panel = new WebMarkupContainer("resultSection");
		panel.setOutputMarkupId(true);
		panel.add(new SociosListView("resultado", panel, this.getModelObject()));
		return panel;
	}

	/**
	 * Agrega los botons: buscar, limpiar & nuevoCliente; al formulario.
	 */
	protected void addButtons(Form<ListadoSocios> form) {
		form.add(new SuperAjaxButton<ListadoSocios>("buscar", form, this.getResultSection()));
		form.add(new SuperAjaxButton<ListadoSocios>("limpiar", form, this.getResultSection()));
		form.add(new PageLink("nuevoCliente", new NuevoSocioPage(this)));
	}

	/**
	 * Retorna el componente wicket que contiene el resultado de la busqueda. Se utiliza para que los botones
	 * lo refresquen via ajax.
	 */
	public Component getResultSection() {
		return this.resultSection;
	}
}*/
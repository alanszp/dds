package ui.webapp

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.CompressedResourceReference

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see uqbar.calculadora.ui.wicket.Start#main(String[])
 */
class WicketApplication extends WebApplication {    
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	def getHomePage = classOf[HomeBandasPage];

}

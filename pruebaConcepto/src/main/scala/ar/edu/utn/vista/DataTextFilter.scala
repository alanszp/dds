package ar.edu.utn.vista

import java.util.ArrayList
import org.uqbar.arena.widgets.TextFilter
import org.uqbar.arena.widgets.TextInputEvent

class DateTextFilter extends TextFilter {
  
	override def transform(celular: Celular) : String = 
	    if (celular.recibeResumenCuenta) "SI" else "NO"
}


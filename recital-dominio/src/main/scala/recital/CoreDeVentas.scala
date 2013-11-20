package recital

import org.uqbar.commons.model.Entity
import compatibility.DomainEntity

class CoreDeVentas {

  var entradas: Set[EntradaAbstracta] = Set()
  var noches: Set[Noche] = Set()
 
  def venderEntrada(entrada: EntradaAbstracta) {
	  try {
		  this.agregarEntrada(entrada);
	  }
	  catch {
	  case e: EntradaExistenteException => throw e //Informar al usuario que no pudo hacer nada!
	  }	
  }
  
  def existeEntrada(entrada : EntradaAbstracta) : Boolean = this.entradas.exists(_ sosOLaTenes entrada)
		  
  def agregarEntrada(entrada : EntradaAbstracta) {
   if (existeEntrada(entrada)){
	  throw new EntradaExistenteException
   }
   
   this.entradas += entrada         
  }
  
  def cantidadEntradasVendidas = this.entradas.toList.map(_.cantidadDeEntradas).sum
  
  def cantidadEntradasVendidas(funcion: EntradaAbstracta => Boolean) = this.entradas.filter(funcion).toList.map(_.cantidadDeEntradas).sum
  
  def anularEntrada(entrada: EntradaAbstracta) {
    entradas = entradas.filter(unaEntrada => !(unaEntrada sosOLaTenes entrada))
  }
  
}
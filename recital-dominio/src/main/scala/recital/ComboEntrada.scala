package recital

import uqbar.arena.persistence.annotations.PersistentClass
import uqbar.arena.persistence.annotations.PersistentField
import uqbar.arena.persistence.annotations.Relation

@PersistentClass
class ComboEntrada extends EntradaAbstracta {
  
  def this(porcentajeDescuento: Double) = {
    this()
    this._porcentajeDescuento = porcentajeDescuento
  }
  
  var _porcentajeDescuento: Double = _
  var _entradas: Set[Entrada] = Set()
  
  def precioEntrada : Double ={
      if(this.precioAux > 1000){
    	  return this.precioAux * _porcentajeDescuento
      }
      	this.precioAux
  }
  
  @PersistentField
  def porcentajeDescuento = _porcentajeDescuento
  def porcentajeDescuento(p: Double) = _porcentajeDescuento = p
  
  @Relation
  def entradas = _entradas//setToList(_entradas)
  def entradas(e:  java.util.List[Entrada]) = _entradas = listToSet(e)
  
  
  def cantidadDeEntradas = this._entradas.size
		  
  def sosOLaTenes(e: EntradaAbstracta):Boolean = {
	  e.isInstanceOf[Entrada] && this.tenesEntrada(e.asInstanceOf[Entrada]) ||
	  e.isInstanceOf[ComboEntrada] && this.tenesAlgunaEntrada(e.asInstanceOf[ComboEntrada])
  }
  
  def precioAux =  _entradas.map(_.precioEntrada).sum
  
  def tenesEntrada(e:Entrada):Boolean = this._entradas.filter(entrada => entrada.sosIgual(e)).size > 0
  
  def tenesAlgunaEntrada(otroCombo:ComboEntrada):Boolean = (this._entradas intersect otroCombo.entradas).size > 0
  
  def agregar(entrada:Entrada) = this._entradas += entrada
 }
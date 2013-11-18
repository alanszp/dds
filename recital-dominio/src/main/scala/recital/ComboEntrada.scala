package recital

import uqbar.arena.persistence.annotations.PersistentClass
import uqbar.arena.persistence.annotations.PersistentField
import uqbar.arena.persistence.annotations.Relation

@PersistentClass
class ComboEntrada extends EntradaAbstracta {
  
  def this(porcentajeDescuento: Double) = {
    this()
    this.porcentajeDescuento = porcentajeDescuento
  }
  
  var porcentajeDescuento: Double = _
  var entradas: Set[Entrada] = Set()
  
  def precioEntrada : Double ={
      if(this.precioAux > 1000){
    	  return this.precioAux * porcentajeDescuento
      }
      	this.precioAux
  }
  
  @PersistentField
  def getPorcentajeDescuento = porcentajeDescuento
  def setPorcentajeDescuento(p: Double) = porcentajeDescuento = p
  
  @Relation
  def getEntradas = setToList(entradas)
  def setEntradas(e:  java.util.List[Entrada]) = entradas = listToSet(e)
  
  
  def cantidadDeEntradas = this.entradas.size
		  
  def sosOLaTenes(e: EntradaAbstracta):Boolean = {
	  e.isInstanceOf[Entrada] && this.tenesEntrada(e.asInstanceOf[Entrada]) ||
	  e.isInstanceOf[ComboEntrada] && this.tenesAlgunaEntrada(e.asInstanceOf[ComboEntrada])
  }
  
  def precioAux =  entradas.map(_.precioEntrada).sum
  
  def tenesEntrada(e:Entrada):Boolean = this.entradas.filter(entrada => entrada.sosIgual(e)).size > 0
  
  def tenesAlgunaEntrada(otroCombo:ComboEntrada):Boolean = (this.entradas intersect otroCombo.entradas).size > 0
  
  def agregar(entrada:Entrada) = this.entradas += entrada
 }
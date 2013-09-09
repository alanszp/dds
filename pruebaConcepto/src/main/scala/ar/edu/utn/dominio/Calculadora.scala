package ar.edu.utn.dominio

import org.uqbar.commons.utils.Observable

@Observable
class Calculadora {
  var acumulador:BigDecimal = null
  var operando:BigDecimal = null
  
  
  def checkAndSet:Boolean = {
    if (acumulador == null) {
      acumulador = operando
      return true
    }
    false
  }
  
  def alFinal : Unit = {
    operando = 0
  }
  
  
  def sumar = {
    checkAndSet
    acumulador += operando
    alFinal
  }
  
  def restar = {
    checkAndSet
    acumulador -= operando
    alFinal
  }
  
  def multiplicar = {
    checkAndSet
    acumulador *= operando
    alFinal
  }
  
  def dividir = {
    if (!checkAndSet)
    	acumulador = acumulador / operando 
    alFinal
  }
   

}
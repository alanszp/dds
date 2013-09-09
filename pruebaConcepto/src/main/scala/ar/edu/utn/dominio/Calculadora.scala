package ar.edu.utn.dominio

import org.uqbar.commons.utils.Observable

@Observable
class Calculadora {
  var acumulador = 0.0
  var operando = 0.0
  var display = 0.0
  var firstTime = true
  
  
  def checkAndSet(value:Double):Boolean = {
    if (firstTime) {
      acumulador = value
      firstTime = false
      return true
    }
    false
  }
  
  def alFinal : Unit = {
    operando = 0
  }
  
  
  def sumar = {
    checkAndSet(0)
    acumulador += operando
    alFinal
  }
  
  def restar = {
    checkAndSet(0)
    acumulador -= operando
    alFinal
  }
  
  def multiplicar = {
    checkAndSet(1)
    acumulador *= operando
    alFinal
  }
  
  def dividir = {
    if (!checkAndSet(operando))
    	acumulador = acumulador / operando 
    alFinal
  }
   

}
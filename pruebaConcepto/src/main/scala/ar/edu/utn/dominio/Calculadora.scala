package ar.edu.utn.dominio

import org.uqbar.commons.utils.Observable

@Observable
class Calculadora {
  var acumulador = 0.0
  var operando = 0.0
 // var display = 0.0
 // var firstTime = true
  
  
 /* def checkAndSet(value:Double):Boolean = {
    if (firstTime) {
      acumulador = value
      firstTime = false
      return true
    }
    false
  }*/
  
  def alFinal : Unit = {
    operando = 0.0
  }
  
  
  def sumar = {
    //checkAndSet(0)
    //this.validar
    acumulador += operando
    alFinal
  }
  
  def restar = {
    //checkAndSet(0)
    //this.validar
    acumulador -= operando
    alFinal
  }
  
  def multiplicar = {
    //checkAndSet(1)
    //this.validar
    acumulador *= operando
    alFinal
  }
  
  def dividir = {
    //if (!checkAndSet(operando))
    //this.validar
    if(operando != 0.0)
    	acumulador = acumulador / operando 
    alFinal
  }
  
  def isNumeric(x: String): Boolean = x.forall(_.isDigit)
  
  def validar ={
    if(! this.isNumeric(operando)){
    	throw new UserException("El numero ingresado no es valido") //VER COMO PONRLO EN EL TEXTBOX
    }
  }
  
  def reset = {
    acumulador = 0.0
    operando = 0.0
    //display = 0.0
    //firstTime = true
  }
  
  def mostrar = {
    acumulador = value
    
  }
}

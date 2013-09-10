package ar.edu.utn.dominio

import org.uqbar.commons.utils.Observable

@Observable
class Calculadora {
  var acumulador = 0.0
  var operando = 0.0
  var firstTime = true
  
  /* esPrimeraVez: Si es la primera vez que se ingresa un dato, setea acumulador en valor recibido. (evita errores con multiplicacion y division)*/
  def esPrimeraVez(value:Double):Boolean = {
    if (firstTime) {
      acumulador = value
      firstTime = false
      return true
    }
    false
  }
  
  def alFinal : Unit = {
    operando = 0.0
  }
  
  
  def sumar = {
    esPrimeraVez(0)
    acumulador += operando
    alFinal
  }
  
  def restar = {
    esPrimeraVez(0)
    acumulador -= operando
    alFinal
  }
  
  def multiplicar = {
    esPrimeraVez(1)
    acumulador *= operando
    alFinal
  }
  
  def dividir = {
    if (!esPrimeraVez(operando))
    if(operando != 0.0)
    	acumulador = acumulador / operando 
    alFinal
  }
  
  def reset = {
    acumulador = 0.0
    operando = 0.0
    firstTime = true
  }
  
}

class Fabrica (var deposito: Deposito, var produccion: Produccion){
	
  def reservar(componente:Componente):Componente ={
    tipoReserva.reservar(componente, this)
  }
  
}
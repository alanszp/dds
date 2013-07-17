class Produccion {
	
  def crear(componente:Componente):Componente ={
    factory = dictionary.get(componente)	
    return factory.crear(componente)
  }
}
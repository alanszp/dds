package recital

import org.uqbar.commons.model.UserException

class EntradaExistenteException extends UserException("La entrada ya fue vendida."){

}

class FilaIncorrectaException extends UserException("La fila es incorrecta."){

}

class AsientoIncorrectoException extends UserException("El asiento es incorrecto."){

}

class CategoriaNoValidaException extends UserException("La categoria no es correcta."){

}
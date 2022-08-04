package common;

/*
 * Enum para utilizar en metodos de Service donde se trate de devolver una respuesta sin utilizar numero planos.
 * Ej: Al crear una entidad, no devolver el id sino exito o error
 */
public enum Response {
ERROR,
SUCCES
}

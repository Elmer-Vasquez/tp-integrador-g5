package common;

/*
 * Podemos utilizar esta clase para buildear las querys con propiedades. En prueba para Cliente
 * Se puede hacer mas funcional, NO FUNCIONA PARA FECHAS O NUMEROS(Por el momento)
 */
public final class QueryUtil {

	private static final String FROM = "FROM ";
	private static final String WHERE = " WHERE ";
	private static final String AS = " AS ";
	private static final String LIKE = " LIKE ";
	private static final String EQUAL = " = ";
	private static final String INNER_JOIN = " INNER JOIN ";

	private QueryUtil() {}
	
	// NO usamos este mtodo por el momento, no es modular
	public static String buildQuery(String property, String className, String value) {
		return property.indexOf(".") == -1 ? FROM + className + whereLike(property, value) 
										: buildInnerProperty(property, className, value);
	}
	
	//Para propiedades propias con tipo de valor primitivo tipo: String, VER si funciona con Date
	public static String buildQueryByStringProperty(String property, String className, String value) {
		return FROM + className + whereLike(property, value);
	}
	
	public static String buildQueryByIntegerProperty(String property, String className, String value) {
		return FROM + className + whereEqual(property, value);
	}
	
	//Para acceder a propiedades de otro objeto
	public static String buildQueryByInnerStringProperty(String property, String className, String value) {
		return buildInnerProperty(property, className, value) + whereLike(property, value);
	}
	
	public static String buildQueryByInnerIntegerProperty(String property, String className, String value) {
		return buildInnerProperty(property, className, value) + whereEqual(property, value);
	}
	
	// Armamos una query con inner join a la propiedad previamente abreviada
	private static String buildInnerProperty(String property, String className, String value) {
		return FROM + className + getAbreviaturaForInner(className) + innerJoin(property, getAbreviatura(className));
	}

	//Usamos este metodo para obtener la abreviutura de la propiedad y sumar a la query EJ: cliente AS cl
	private static String getAbreviaturaForInner(String className) {
		return AS + className.substring(0, 2);
	}
	
	private static String getAbreviatura(String className) {
		return className.substring(0,2);
	}
	//Este metodo lo usamos para buscar con la comparación LIKE
	private static String like(String value) {
		return LIKE + "'%" + value + "%'";
	}
	
	//Este metodo lo usamos para buscar con la comparación EQUAL
	private static String equal(String value) {
		return EQUAL + value;
	}
	
	//Inner join en String para acoplar a querys
	private static String innerJoin(String property, String className) {
		String originalProperty = property.substring(0, property.indexOf("."));
		return INNER_JOIN + className.concat(".") + originalProperty + getAbreviaturaForInner(originalProperty);
	}
	
	//WHERE en String para acoplar a querys
	private static String whereLike(String property, String value) {
		
		//Buscamos si la propiedad esta compuesta con el index del caracter '.':
		int posPunto = property.indexOf(".");
		String searcheableProperty = posPunto != -1 ? getAbreviatura(property).concat(".") + property.substring(posPunto+1) : property ;
		return WHERE + searcheableProperty + like(value);
	}
	
	//Where en tipos INT para acoplar a querys
	private static String whereEqual(String property, String value) {

		// Buscamos si la propiedad esta compuesta con el index del caracter '.':
		int posPunto = property.indexOf(".");
		String searcheableProperty = posPunto != -1
				? getAbreviatura(property).concat(".") + property.substring(posPunto + 1)
				: property;
		return WHERE + searcheableProperty + equal(value);
	}
}

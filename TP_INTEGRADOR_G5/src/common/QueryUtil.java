package common;

/*
 * Podemos utilizar esta clase para buildear las querys con propiedades. En prueba para Cliente
 */
public final class QueryUtil {

	private static final String FROM = "FROM ";
	private static final String WHERE = "WHERE ";
	private QueryUtil() {}
	
	public static String buildQuery(String property, String className, String value) {
		return FROM + className + " " + (property.indexOf(".") == -1 ? buildOneProperty(property) : buildInnerProperty(property)) + value;
	}
	
	private static String buildInnerProperty(String property) {
		return "prueba";
	}
	
	private static String buildOneProperty(String property) {
		return WHERE + property + "=";
	}
}

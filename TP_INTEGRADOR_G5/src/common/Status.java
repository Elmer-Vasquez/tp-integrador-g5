package common;

/*
 * Status para utilizar en response de los service
 */
public final class Status {

	public static String getGenerateStatus(Response response) {
		return response == Response.SUCCES ? genericSuccesStatus(Dictionary.CREATED) : genericErrorStatus(Dictionary.CREATE);
	}

	public static String getDeleteStatus(Response response) {
		return response == Response.SUCCES ? genericSuccesStatus(Dictionary.DELETED) : genericErrorStatus(Dictionary.DELETE);
	}
	
	public static String getUpdateStatus(Response response) {
		return response == Response.SUCCES ? genericSuccesStatus(Dictionary.UPDATED) : genericErrorStatus(Dictionary.UPDATE);
	}
	
	private static String genericSuccesStatus(String accion) {
		return "El registro se " + accion + "correctamente";
	}
	
	private static String genericErrorStatus(String accion) {
		return "Ocurrió un error al " + accion + "el registro";
	}
}

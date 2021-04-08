package exceptions;
@SuppressWarnings("serial")
public class DocTypeException extends Exception {
	private String type;
	
	public DocTypeException(String type) {
		super("The maximum capacity has been exceeded CAMBIAR.");
		this.type = type;
	}

	public String getType() {
		return type;
	}
}

package exceptions;
@SuppressWarnings("serial")
public class DocTypeException extends Exception {
	private String type;
	
	public DocTypeException(String type) {
		super("Documento de identidad incorrecto.");
		this.type = type;
	}

	public String getType() {
		return type;
	}
}

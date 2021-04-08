package model;

public class Person {

	//Attribute.
	private String identification;
	
	//Relationship.
	
	private DocumentType type;

	public Person(String identification, String type) {
		this.identification = identification;
		this.type = DocumentType.valueOf(type);
	}

	public String getIdentification() {
		return identification;
	}

	public DocumentType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Person [identification=" + identification + ", type=" + type + "]";
	}
	
	

}

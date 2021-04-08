package model;

public class Person {

	//Attribute.
	private String identification;
	
	//Relationship.
	
	private typeDocument type;

	public Person(String identification, String type) {
		this.identification = identification;
		this.type = typeDocument.valueOf(type);
	}

	public String getIdentification() {
		return identification;
	}

	public typeDocument getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Person [identification=" + identification + ", type=" + type + "]";
	}
	
	

}

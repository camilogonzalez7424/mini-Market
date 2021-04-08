package model;

import java.time.LocalDate;
import java.util.ArrayList;

//import exceptions.NoIngress;

public class Market {
	
	//Attributes.
	private int count = 0;
	private ArrayList<Person> persons;
	
	public Market() {
		persons = new ArrayList<>();		
	}
	
	public boolean addPerson(String identification, String type) throws NoIngress{
		count++;
		boolean out = false;
		
		int day = LocalDate.now().getDayOfMonth();
		System.out.println("Dia del mes es:"+day);
		int penultima = identification.length()-2;
		System.out.println("penultima es: "+identification.charAt(penultima));
		int id = Integer.parseInt(String.valueOf(identification.charAt(penultima)));
		System.out.println("este es: "+id);
		if(!type.equals("TI")) {
		if((day%2 == 0) && id%2 != 0) {
			persons.add(new Person(identification,type));
			System.out.println("Esta hecho Bro :)");
			out = true;
		}else if((day%2 != 0) && (id%2 == 0)){
			persons.add(new Person(identification,type));
			System.out.println("Esta hecho Bro :)");
			out = true;
		}else {
			System.out.println("F mi perro");
			//throw new NoIngress(type,id);
		}		
		}else {
			 //throw new MaximumCapacityException(MAX_CAP,getTotalWeight()+we);
			System.out.println("Usted es un menor rey");

			//throw new NoIngress(type,id);
		}
		
		return out;
	}
	
	public int getCount() {
		return count;
	}
	
	public ArrayList<Person> getPersons() {
		return persons;
	}
	
	@Override
	public String toString() {
		String out = "";
		out += persons.toString();
		
		return out;
	}

}

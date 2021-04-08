package model;

import java.util.ArrayList;

import exceptions.DocTypeException;
import exceptions.ProblemDayException;


public class Market {
	
	//Attributes.
	private int count = 0;
	private ArrayList<Person> persons;
	
	public Market() {
		persons = new ArrayList<>();		
	}
	
	public boolean addPerson(String identification, String type,int day) throws DocTypeException, ProblemDayException {
		count++;
		boolean out = false;
		
		System.out.println("Dia del mes es:"+day);
		int penultima = identification.length()-2;
		System.out.println("penultima es: "+identification.charAt(penultima));
		int id = Integer.parseInt(String.valueOf(identification.charAt(penultima)));
		System.out.println("este es: "+id);
		if(!type.equals("TI")) {
			if((day%2 == 0) && (id%2 != 0) || (day%2 != 0) && (id%2 == 0)) {
			persons.add(new Person(identification,type));
			System.out.println("Esta hecho Bro :)");
			out = true;
			}else {
				System.out.println("Hoy no te toca");
				throw new ProblemDayException(day);
			}	
		}else {
			System.out.println("Usted es un menor rey");
			throw new DocTypeException(type);

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

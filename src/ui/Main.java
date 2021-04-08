package ui;
import java.util.Scanner;

import model.Market;

public class Main {
    Scanner sc;
    Market miniMarket;
	
	Main(){
        sc = new Scanner(System.in);
        miniMarket = new Market();
		
    }
    
	public static void main(String[] args) {
		
		System.out.println("Welcome to the aplication");
		Main ppal= new Main();
		
		int option=0;
		
		do{
			option= ppal.showMenu();
			ppal.executeOperation(option);
			
		}while (option!=0);
		
	}
	
	public int showMenu() {
		int option=0;

		System.out.println(
				"Main menu, please pick an option\n" +
				"(1) Registration \n" +
				"(2) Consult \n"+ 
				"(0) To leave the application"
				);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}
	
	public void executeOperation(int operation) {
		
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			addPerson();
			System.out.println(miniMarket.toString());
			break;
		case 2:
			System.out.println(miniMarket.getCount());
			break;
		default:
			System.out.println("Error, wrong option");
		
		}
	

	}
	
	public void addPerson() {
		try {
		int selection;
		String identification = "";
		String type = "";
		
		System.out.println("Seleccione el número que respresenta el tipo de documento\n"+
				"*******************Document******************** \n"+
				"(1) Si es TI-\"Tarjeta de Identidad.\"\n"+
				"(2) Si es CC-\"Cedula de Ciudadania.\"\n"+
				"(3) Si es PP-\"Pasaporte.\"\n"+
				"(4) Si es CE-\"Cedula de Extranjeria.\"\n");
		
			selection=sc.nextInt();
			
		switch (selection){
			case 1:
					type = "TI";
					break;
			
			case 2:
					type = "CC";
					break;
			
			case 3:
					type = "PP";
					break;
			
			case 4:
					type = "CE";
					break;
			
			default: 
			System.out.println("Error");

		}
		
		System.out.println("Escriba el número");
		
		sc.nextLine(); //Limpiar el Buffer
		
		identification = sc.nextLine();
		
		miniMarket.addPerson(identification,type);
		}catch(NoIngress mce) {
			System.out.println("La persona no puede ingresar.");
		      System.out.println("El tipo de identificación es: "+mce.getType()+" y penultimo dijito de su documento es: "+mce.getId());
		      mce.printStackTrace();
		}	
	}

}


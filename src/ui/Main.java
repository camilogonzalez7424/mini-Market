package ui;
import java.time.LocalDate;
import java.util.Scanner;

import exceptions.DocTypeException;
import exceptions.ProblemDayException;
import model.Market;

public class Main {
    private Scanner sc;
    private Market miniMarket;
	
	Main(){
        sc = new Scanner(System.in);
        miniMarket = new Market();
		
    }
    
	public static void main(String[] args) {
		
		System.out.println("Bienvenido a Mi Barrio Te Quiere");
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
				"Menú principal, por favor elija una opcion:\n" +
				"(1) Registrarse \n" +
				"(2) Consultar \n"+ 
				"(0) Salir"
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
			System.out.println("La cantidad de personas que han intentado ingresar es: "+miniMarket.getCounter());
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
		
		System.out.println("Seleccione el número que respresenta el tipo de documento:\n"+
				"*******************Documento**************************** \n"+
				"(1) Si es TI - \"Tarjeta de Identidad.\"\n"+
				"(2) Si es CC - \"Cedula de Ciudadania.\"\n"+
				"(3) Si es PP - \"Pasaporte.\"\n"+
				"(4) Si es CE - \"Cedula de Extranjeria.\"\n");
		
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

		int day = LocalDate.now().getDayOfMonth();

		miniMarket.addPerson(identification, type, day);
		}catch(DocTypeException dte) {
			System.out.println("La persona no puede ser menor de edad para poder ingresar,posee("+dte.getType()+")");
		    System.err.println(dte.getMessage());
		    dte.printStackTrace();
		}catch(ProblemDayException pde) {
			System.out.println("La persona no puede puede ingresar el dia de hoy("+pde.getDay()+")");
		    System.err.println(pde.getMessage());
		    pde.printStackTrace();
		}
	}

}


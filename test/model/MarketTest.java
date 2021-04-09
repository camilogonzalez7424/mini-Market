package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.DocTypeException;
import exceptions.ProblemDayException;

class MarketTest {
	private Market myMarket;
	private void setupScenary1() {
		myMarket = new Market();
	}

	@Test
	public void testSetAdd1() { //Que lo agrege.
		setupScenary1();		
		
		String id = "1005897813";
		String type = "CC";
		int day = 2;
		
		try {
			boolean ans = myMarket.addPerson(id, type, day);
			assertTrue(ans);
			
		}catch(DocTypeException dte) {
			fail("Tipo documento expected");
		}catch(ProblemDayException pde) {
			fail("dia malo expected");
		}	
	}
	
	@Test
	public void testSetAdd2() { //No agregar por el documento TI
		setupScenary1();		
		
		String id = "1000604256";
		String type = "TI";
		int day = 4;
		

		try {
			boolean ans = myMarket.addPerson(id, type, day);
			assertFalse(ans);
			
		}catch(DocTypeException | ProblemDayException wi) {
			wi.printStackTrace();
		}
		
	}
	
	@Test
	public void testSetAdd3() { //No agregar por el dia ni por la TI
		setupScenary1();		
		
		String id = "1193266644";
		String type = "CC";
		int day = 12;
		

		try {
			boolean ans = myMarket.addPerson(id, type, day);
			assertFalse(ans);
			
		}catch(DocTypeException | ProblemDayException we) {
			we.printStackTrace();
		}
		
	}

}

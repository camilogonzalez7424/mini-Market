package exceptions;
@SuppressWarnings("serial")
public class ProblemDayException extends Exception{
	private int day;
	
	public ProblemDayException(int day) {
		super("Dia incorrecto para ingresar según la ley vigente.");
		this.day = day;
	}
	
	public int getDay() {
		return day;
	}
}

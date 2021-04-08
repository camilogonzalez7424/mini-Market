package exceptions;
@SuppressWarnings("serial")
public class ProblemDayException extends Exception{
	private int day;
	
	public ProblemDayException(int day) {
		super("DIAAAAAAAAAAA MALO CAMBIAR.");
		this.day = day;
	}
	
	public int getDay() {
		return day;
	}
}

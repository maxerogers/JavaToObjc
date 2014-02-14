import java.util.Calendar;


public class Male extends Person implements Gender{

	public Male(String name, Calendar birthday) {	super(name, birthday);}
	@Override
	public String gender() {	return "Male";}
	@Override
	public boolean isMale() {	return true;}
	@Override
	public boolean isFemale() {	return false;}

}

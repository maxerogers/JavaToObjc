import java.util.Calendar;


public class Female extends Person implements Gender{
	private String maidenName;
	public Female(String name, Calendar birthday) {	super(name, birthday);}
	@Override
	public String gender() {	return "Female";}
	@Override
	public boolean isMale() {	return false;}
	@Override
	public boolean isFemale() {	return true;}
	public String maidenName(){
		return maidenName;
	}
	public void setMaidenName(String s){ maidenName = s;}
	
	@Override
	public String toString()
	{
		String result = super.toString();
		int x = result.indexOf("Spouse");
		if(x > 0){
			return result.substring(0,x) +"Maiden:\t"+ this.maidenName +"\n\t\t"+ result.substring(x);
		}
		return result;
	}
}

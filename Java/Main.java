import java.util.Calendar;

/**
 * 
 * @author max
 * 02-10-2014
 */
public class Main {
	public static void main(String[] args)
	{
		Male obama = new Male("Barack Obama", bday(8, 4, 1961));
		Female michelle = new Female("Michelle Obama", bday(01, 17, 1964));
		michelle.setSpouse(obama);
		michelle.setMaidenName("Robinson");
		Female malia = new Female("Malia Obama", bday(07, 04, 1998));
		Female natasha = new Female("Natasha Obama", bday(06, 10, 2001));
		obama.addChild(malia);
		obama.addChild(natasha);
		System.out.println(obama);
		System.out.println(michelle);
		System.out.println(malia);
		System.out.println(natasha);
	}
	private static Calendar bday(int month, int day, int year){
		Calendar temp = Calendar.getInstance();
		temp.set(year, month, day);
		return temp;
	}
}

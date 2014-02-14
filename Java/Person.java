import java.util.ArrayList;
import java.util.Calendar;

/**
 *	
 * @author max
 *
 */
public abstract class Person implements Gender
{
	private String name;
	private Calendar birthday;
	private Person father;
	private Person mother;
	private Person spouse;
	private ArrayList<Person> children;
	public Person(String name, Calendar birthday)
	{
		this.name = name;
		this.birthday = birthday;
	}
	public String getName(){return name;}
	public void setName(String name){ this.name = name;}
	public Calendar getBirthday(){return birthday;}
	public void setBirthday(Calendar birthday){ this.birthday = birthday;}
	public int calculateAge(){
		Calendar today = Calendar.getInstance();
		Calendar dob = birthday;
		int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
		if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
			  age--;  
			} else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
			    && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
			  age--;  
			}
		return age;
	}
	
	public Person getFather(){ return father;}
	public void setFather(Person p){father = p;}
	public Person getMother(){ return mother;}
	public void setMother(Person p){mother = p;}
	public Person getSpouse(){return spouse;}
	public void setSpouse(Person p){
		spouse = p; 
		if(p.getSpouse() == null)
		{	p.setSpouse(this);	}
	}
	public void addChild(Person p){ 
		if(children == null)
			children = new ArrayList<Person>();
		children.add(p);
		if(isMale()){
			p.father = this;
		}else{
			p.mother = this;
		}
		if(spouse != null && !spouse.alreadyClaimedChild(p)){
			if(isMale()){
				p.mother = spouse;
				
			}else{
				p.father = spouse;
			}
			spouse.addChild(p);
		}
	}
	public boolean alreadyClaimedChild(Person p){
		if(children == null)
			return false;
		//normally i would setup some sort of search tree but since people rarely have more than 3 kids this shouldn't be an issue
		for(Person child : children)
		{
			if(child.name.equals(p.name))
				return true;
		}
		return false;
	}
	public void addParents(Person dad, Person mom){
		this.father = dad;
		this.mother = mom;
	}
	public ArrayList<Person> getChildren(){return children;}
	/**
	 * 
	 * @param int index i
	 * @return Person p
	 * @throws IndexOutOfBoundsException
	 */
	public Person getChild(int i) throws IndexOutOfBoundsException{
		return children.get(i);
	}
	
	public String toString(){
		String result =  name+":\t{Age:\t"+this.calculateAge(); 
		result+= "\n\t\tBDAY:\t"+birthday.get(Calendar.MONTH)+"/"+birthday.get(Calendar.DATE)+"/"+birthday.get(Calendar.YEAR);
		if(spouse != null)
			result += "\n\t\tSpouse:\t"+spouse.name;
		if(father != null)
			result += "\n\t\tFather:\t"+father.name;
		if(mother != null)
			result += "\n\t\tMother:\t"+mother.name;
		if(children != null){
			result += "\n\t\tChildren: ";
			for(int i=0;i<children.size();i++){
				result += "\n\t\t\t"+children.get(i).name;
			}
		}
		return result+"}\n";
	}
}

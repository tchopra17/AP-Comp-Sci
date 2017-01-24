
public class Chick implements Animal {
	private String myType;
	private String mySound;
	private String mySound2;

	Chick(String string, String string2, String string3){
		myType = "chick";
		mySound = "cheep";
		mySound2 = "cluck";
	}

	public String getSound(){
		if (Math.random() >= .5) {
			return mySound;
		} else {
			return mySound2;
		}
	}

	public String getType(){
		return myType;
	}
}


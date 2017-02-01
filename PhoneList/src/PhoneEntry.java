
public class PhoneEntry implements Comparable 
{
	private String name;
	private String phoneNumber;
	
	public PhoneEntry (String initName, String initPhoneNumber) 
	{
		name = initName;
		phoneNumber = initPhoneNumber;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getPhone()
	{
		return phoneNumber;
	}
	
	public int compareTo (Object obj)
	{
		PhoneEntry entry = (PhoneEntry) obj;
		return name.compareTo (entry.getName());
	}
	
	public boolean equals (Object obj)
	{
		return (compareTo(obj) == 0);
	}
	
	public String toString()
	{
		return name + " " + phoneNumber;
	}
}
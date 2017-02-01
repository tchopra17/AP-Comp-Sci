import chn.util.*;

public class Tester {
	
	public static void main(String[] args) {
		PhoneList list;		// the PhoneList class needs to be written
		int command;
		
		// create new phone list
		list = new PhoneList();
		ConsoleIO input = new ConsoleIO();
		
		do {
		
			// prompt user for a comand.
			System.out.println("Enter a command");
			System.out.println("  0 - quit");
			System.out.println("  1 - add an entry");
			System.out.println("  2 - look up an entry");
			System.out.println("  3 - remove an entry");
			System.out.println("  4 - list all entries");
			System.out.print("Command: ");
			command = input.readInt();
			
			switch(command)
			{
				case 0: break;
				case 1:	addEntry(list); break;
				case 2: lookUpEntry(list); break;
				case 3: removeEntry(list); break;
				case 4: listEntries(list); break;
				default: System.out.println("Invalid choice");
			}
		
		} while (command != 0);
		System.out.println("Bye!");	
	}
	
	public static void addEntry(PhoneList list)
	{
		ConsoleIO input = new ConsoleIO();

		System.out.print("Enter new name: ");
		String name = input.readToken();
		System.out.print("Enter phone number: ");
		String phone = input.readToken();
		list.add(name, phone);
					// creates a PhoneEntry and inserts it into PhoneList
					// in sorted order
		System.out.println("Added " + name + " to the phone list");
	}
	
	public static void lookUpEntry(PhoneList list)
	{
		ConsoleIO input = new ConsoleIO();
		
		System.out.print("Enter name: ");
		String name = input.readToken();
		String phone = list.lookUp(name);
					// find PhoneEntry with given name and return phone #
		if (phone == null)
			System.out.println(name + " was not found in phone list");
		else
			System.out.println(name + "'s phone number is " + phone);
	}
	
	public static void removeEntry(PhoneList list)
	{
		ConsoleIO input = new ConsoleIO();
		
		System.out.print("Enter name: ");
		String name = input.readToken();
		String phone = list.lookUp(name);

		boolean found = list.remove(name);
								// remove PhoneEntry in PhoneList 
		if (found)
			System.out.println(name + " was removed from phone list");
		else
			System.out.println(name + " was not found in phone list");
	
	}
	
	public static void listEntries(PhoneList list)
	{		
		list.listAll();		// list all PhoneEntry info in order	
	}
}


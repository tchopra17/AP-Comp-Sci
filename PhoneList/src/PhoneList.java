import java.util.*;

public class PhoneList
{
    LinkedList<PhoneEntry> list ;

    public PhoneList()
    {
        list = new LinkedList<PhoneEntry>();  
    }

    public void listAll()
    {
        Iterator<PhoneEntry> iter = list.iterator();
        while (iter.hasNext())
        {
            PhoneEntry obj = iter.next();
            System.out.println(obj);
        }
    }

    public void add (String name, String phone)
    {
        PhoneEntry entry =  new PhoneEntry(name,phone);
        ListIterator<PhoneEntry> iter = list.listIterator();
        while (iter.hasNext())
        {
            if (entry.compareTo(iter.next()) < 0)
            {
                iter.previous();
                iter.add(entry);
                return;
            }
        }
        iter.add(entry);
 
    }

    public String lookUp (String name)
    {
        ListIterator<PhoneEntry> iter = list.listIterator();
        PhoneEntry temp = null;
        while (iter.hasNext())
        {
            temp = iter.next();
            if (name.equals(temp.getName()))
            {
                return temp.getPhone();
            }
        }
        return null;
    }

    public boolean remove(String name)
    {
       ListIterator<PhoneEntry> iter = list.listIterator();
        PhoneEntry temp = null;
        while (iter.hasNext())
        {
            temp = iter.next();
            if (temp.getName().equals(name))
            {
                iter.remove();
                return true;
            }
        }
        return false;
    }

}
import java.util.*;

public class SinglyLinkedList<E extends Comparable<E>>
{
    private ListNode<E> first;  // first element
    private ListNode<E> last;
    /**
     *  Constructor for the SinglyLinkedList object
     *  Generates an empty list.
     */
    public SinglyLinkedList()
    {
        first = null;
        last = null;
    }

    /**
     *  Returns the first element in this list.
     *
     * @return  the first element in the linked list.
     */
    public E getFirst()
    {
        if (first == null)
        {
            throw new NoSuchElementException();
        }
        else
            return first.getValue();
    }

    /**
     *  Inserts the given element at the beginning of this list.
     *
     * @param  value  the element to be inserted at the beginning of this list.
     */
    public void addFirst(E value)
    {
        first = new ListNode<E>(value, first);
        if (last == null)
        {
            last = first;
        }
    }

    /**
     *  Returns the first element in this list.
     *
     * @return  the first element in the linked list.
     */
    public E getLast()
    {
        if (last == null)
        {
            throw new NoSuchElementException();
        }
        else
            return last.getValue();
    }

    /**
     *  Inserts the given element at the beginning of this list.
     *
     * @param  value  the element to be inserted at the beginning of this list.
     */
    public void addLast(E value)
    {
        ListNode<E> test;
        if (first == null)
        {
            test = new ListNode<E>(value, null);
            first = test;
            last = test;
        }
        else
        {
            test = last;
            last = new ListNode<E>(value, null); 
            test.setNext(last);
        }
    }

    /**
     *  Print the contents of the entire linked list
     */
    public void printList()
    {
        ListNode<E> temp = first;// start from the first node
        while (temp != null)
        {
            System.out.println(temp.getValue() + " ");
            temp = temp.getNext();// go to next node
        }
        System.out.println();
    }

    /**
     *  Returns a string representation of this list. The string
     *  representation consists of the list's elements in order,
     *  enclosed in square brackets ("[]"). Adjacent elements are
     *  separated by the characters ", " (comma and space).
     *
     * @return    string representation of this list
     */
    public String toString()
    {
        String s = "[";

        ListNode<E> temp = first;  // start from the first node
        while (temp != null)
        {
            s += temp.getValue(); // append the data
            temp = temp.getNext();      // go to next node
            if (temp != null)
                s += ", ";
        }
        s += "]";
        return s;
    }

    public int size()
    {
        int size = 0;
        ListNode<E> temp = first;  // start from the first node
        while (temp != null)
        {
            size++;
            temp = temp.getNext();
        }
        return size;
    }

    public void insert (E element)
    {
        Comparable<E> elemC = (Comparable<E>) element;
        ListNode<E> temp = first;
        ListNode<E> back = first;
        ListNode<E> newNode = new ListNode(element,null);
        if((first == null) || (first.getValue().compareTo(element) >= 0))
        {
            newNode.setNext(first);  
            first = newNode; 
        }
        else
        {
            temp = first;
            while((temp.getNext() != null) &&
            (temp.getNext().getValue().compareTo(element) < 0))
            {
                temp = temp.getNext();
            }
            newNode.setNext( temp.getNext());
            temp.setNext(newNode);
        }
    }

    public E find (E element)
    {
        ListNode<E> temp = first;

        while(temp != null)
        {
            if(element.equals(temp.getValue()))
            {
                return temp.getValue();
            }
            temp = temp.getNext();
        }
        return null;
    }

    public ListNode<E> remove(E element)
    {
        ListNode<E> back = null;
        ListNode<E> temp = first;

        while(temp != null && element.equals(temp.getValue()) == false)
        {
            back = temp;
            temp = temp.getNext();
        }
        if (temp == null)
        {
            return null;
        }
        if (back == null)
        {
            first = temp.getNext();
        }
        else
        {
            back.setNext(temp.getNext());
        }
        return temp;
    }

    public void clear()
    {
        first = null;
        last = null;
    }

    public void printBackwards()
    {
        printBackwards(first);
    }

    private void printBackwards (ListNode<E> node)
    {
        ListNode<E> temp = node;
        if (temp == null)
        {
            return;
        }
        printBackwards(temp.getNext());
        System.out.println(temp.getValue());
    }
    public SLLIterator<E> iterator()
	{
		return new SLLIterator<E>(first);
	}
}


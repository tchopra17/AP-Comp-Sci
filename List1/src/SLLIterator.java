import java.util.*;

	public class SLLIterator<E> implements Iterator<E> 
	{

		private ListNode<E> nextNode;
	
		public SLLIterator(ListNode<E> node)
		{
			// init 'nextNode' to 'node'
		    nextNode = node;
		}
	
		public boolean hasNext()
		{
			// true if 'nextNode' is not null
		    if (nextNode != null)
			return true;
		    else
			return false;
		}
		
		public E next()
		{
		    ListNode<E> tmpNextNode;

			if (nextNode == null)
				throw new NoSuchElementException();
		
			// return the value stored in the current 'nextNode' and 
			// update 'nextNode' to the next node in the list

			tmpNextNode = nextNode;

			nextNode = nextNode.getNext();

			return tmpNextNode.getValue();
		}
	
		// not implemented
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
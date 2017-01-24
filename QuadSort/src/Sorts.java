import java.util.*;

/**
 *  Description of the Class
 *
 * @author     Your Name Here
 * @created    Month Day, Year
 */
public class Sorts
{
  private long steps;

  /**
   *  Description of Constructor
   *
   * @param  list  Description of Parameter
   */
  Sorts()
  {
    steps = 0;
  }

  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void bubbleSort(int[] list)
  {
	  steps++;
	  for (int outer = 0; outer < list.length - 1; outer++)
	  {
	    steps += 3;
	    for (int inner = 0; inner < list.length - outer - 1; inner++)
	    {
	      steps += 3;
	      if (list[inner] > list[inner+1])
	      {
	        int temp = list[inner];
	        list[inner] = list[inner + 1];
	        list[inner + 1] = temp;
	        steps += 3;
	      }
	    }
	  }
	}

  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void selectionSort(int[] list)
  {
	  int min, temp;
	  steps++;
	  for (int outer = 0; outer < list.length - 1; outer++)
	  {
	    min = outer;
	    steps += 3;
	    for (int inner = outer + 1; inner < list.length; inner++)
	    {
	    	steps += 3;
	      if (list[inner] < list[min])
	      {
	        min = inner;
	        steps += 3;
	      }
	    }
	    //swap list[outer] & list[flag]
	    temp = list[outer];
	    list[outer] = list[min];
	    list[min] = temp;
	  }
	}
  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void insertionSort(int[] list)
  {
	  {
		  steps++;
		  for (int outer = 1; outer < list.length; outer++)
		  {
		    int position = outer;
		    int key = list[position];
		    steps += 3;
		    
		    // Shift larger values to the right
		    while (position > 0 && list[position - 1] > key)
		    {
		      list[position] = list[position 	- 1];
		      position--;
		      steps += 3;
		    }
		    list[position] = key;
		  }
		}
  }

 /**
   *  Takes in entire vector, but will merge the following sections
   *  together:  Left sublist from a[first]..a[mid], right sublist from
   *  a[mid+1]..a[last].  Precondition:  each sublist is already in
   *  ascending order
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  mid    midpoint index of range of values to be sorted
   * @param  last   last index of range of values to be sorted
   */

  /**
   *  Recursive mergesort of an array of integers
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  last   ending index of range of values to be sorted
   */
  public void mergeSort(int[] a, int first, int last)
  {	
	  steps += 5;
      if (first < last)
      {
          int mid = first + (last - first) / 2;
         
          mergeSort(a, first, mid);
          mergeSort(a, mid + 1, last);
          merge(a, first, mid, last);
      }

  }
  
  public void merge(int[] a, int first, int mid, int last) {
	  steps += 2;
      int[] tempArray = new int[a.length];
      for (int x = first; x <= last; x++)
      {
          steps += 3;
          tempArray[x] = a[x];
      }
      steps += 4;
      int i = first;
      int j = mid + 1;
      int k = first;
      while (i <= mid && j <= last)
      {
          steps += 2;
          if (tempArray[i] <= tempArray[j])
          {
              steps += 2;
              a[k] = tempArray[i];
              i++;
          }
          else
          {
              steps += 2;
              a[k] = tempArray[j];
              j++;
          }
          k++;
      }
      steps++;
      while (i <= mid)
      {
          steps += 3;
          a[k] = tempArray[i];
          k++;
          i++;
      }
  }
  

  /**
   *  Recursive quicksort of an array of integers
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  last   ending index of range of values to be sorted
   */
  public void quickSort(int[] list, int first, int last) {
	  	  steps += 4;
		  int g = first, h = last;

		  int midIndex = (first + last) / 2;
		  int dividingValue = list[midIndex];
		  do
		  {
			steps += 3;
		    while (list[g] < dividingValue)
		      g++;
              steps++;
		    while (list[h] > dividingValue)
		      h--;
		      steps++;
		    if (g <= h)
		    {
		      steps += 5;
		      //swap(list[g], list[h]);
		      int temp = list[g];
		      list[g] = list[h];
		      list[h] = temp;
		      g++;
		      h--;
		    }
		  }
		  while (g < h);
		  steps += 2;
		  if (h > first){
		    quickSort (list,first,h);
		    steps++;
		  }
		  if (g < last){
		    quickSort (list,g,last);
		    steps++;
		  }
		}


  /**
   *  Accessor method to return the current value of steps
   *
   */
  public long getStepCount()
  {
    return steps;
  }

  /**
   *  Modifier method to set or reset the step count. Usually called
   *  prior to invocation of a sort method.
   *
   * @param  stepCount   value assigned to steps
   */
  public void setStepCount(int stepCount)
  {
    steps = stepCount;
  }
}


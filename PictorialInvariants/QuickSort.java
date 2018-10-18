package loopInvariants;

/** This program sorts an array of numbers using the quick sort method*/

public class QuickSort {
	public static int partition (int a[], int left, int right) {
		int l_spot= left +1;
		int pivot = a[left];
		int r_spot = right;
		int temp = 0;
		//makes sure to check all the elements in the array
		while (l_spot <= r_spot) {
			//checks if the value a[l_spot] is less than or equals to pivot
			if (a[l_spot] <= pivot) {
				l_spot++;
			}
			//checks if the value a[r_spot] is greater than or equals to pivot
			if (a[r_spot] >= pivot) {
				r_spot--;
			}
			//if value at l_spot is greater than pivot and value at r_spot is
			// less than pivot then swap the values provided that the position
			// of l-spot is lesser than position of r_spot
			if ((l_spot <= r_spot) && (a[l_spot] > pivot) && (a[r_spot] < pivot)) {
				// swap(a[l_spot], a[r_spot]);
				temp = a[l_spot];
				a[l_spot] = a[r_spot];
				a[r_spot] = temp;
			}
		}
		/*swaps value at a[r_spot] with pivot since r_spot < l_spot
		 * thus, a[r_spot] < pivot
		 */
		a[left] = a[r_spot];
		a[r_spot]= pivot;
		// returns the new position of pivot
		return r_spot;
	}
	
	
	/*calls the quicksortKernel 
	 * @param : a[] : array 
	 * 			n : length of array
	 */
	public static void quicksort (int a[], int n) {
		if (a.length != 0) 
		quicksortKernel(a, 0, n-1);
	}
	
	/*
	 * @param : a[] : array 
	 * 		   left  : left index of the array
	 *         right: the right most index of the array 
	 * @return: 0 if the array a[] is sorted
	 */
	public static int quicksortKernel(int a[], int left, int right) {
		//stores the value of the new position of pivot in index
		int index = partition(a, left, right);
		
		//if index = 0, then the left part of the original index has been sorted
		if(left < right) {
			/*calls the partition function on the left side of the
			 * 'index' 
			 */
			if(index > 0) {
				quicksortKernel(a, left, index-1);
			}
			/*calls the partition function on the right side of the
			 * 'index' 
			 */
			if(index < right) {
				quicksortKernel(a, index + 1, right);
			}
		}
		return 0;
	}
	
	
	public static void main (String args[]) {
		
		//testing in main 
	
		
		//testing with a sorted array 
		int [] arr1 = {10, 30, 40, 50, 60, 70, 80, 90};
		
		//testing with a random set of integers
		int [] arr2 = {60, 70, 100, 5, 3, 4, 1, 9};
		
		//testing with an empty array 
		int [] arr3 = {};
		
		//testing with the minimum value at the start of the array
		int [] arr4 = {1, 70, 100, 5, 3, 4, 2, 9};
		
		//testing with the minimum value at the end of an array
		int [] arr5 = {60, 70, 100, 5, 3, 40, 2, 1};
		
		
		quicksort(arr1, arr1.length);
		quicksort(arr2, arr2.length);
		quicksort(arr3, arr3.length);
		quicksort(arr4, arr4.length);
		quicksort(arr5, arr5.length);
		
		System.out.println("Sorted array : ");
		System.out.print("{");
		for (int i= 0; i < arr1.length-1; i++) {
			System.out.print(arr1[i] + ", ") ;
		}
		System.out.print(arr1[arr1.length-1] + "} \n ");
		
		System.out.println("Sorted array (2): ");
		System.out.print("{");
		for (int i= 0; i < arr2.length-1; i++) {
			System.out.print(arr2[i] + ", ");
		}
		System.out.print(arr1[arr2.length-1] + "} ");
		
		System.out.println("\nSorted array (3): ");
		for (int i= 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + ", ");
		}
		//System.out.print(arr3[arr3.length-1] + "} ");
		
		System.out.println("\n Sorted array (4): ");
		System.out.print("{");
		for (int i= 0; i < arr4.length-1; i++) {
			System.out.print(arr4[i] + ", ");
		}
		System.out.print(arr4[arr4.length-1] + "} ");
		
		System.out.println("\nSorted array(5): ");
		System.out.print("{");
		for (int i= 0; i < arr5.length-1; i++) {
			System.out.print(arr5[i] + ", ");
		}
		System.out.print(arr5[arr5.length-1] + "} ");
	}
}


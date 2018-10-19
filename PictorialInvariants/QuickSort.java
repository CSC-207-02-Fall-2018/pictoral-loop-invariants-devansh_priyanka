package loopInvariants;

/** This program sorts an array of numbers using the quick sort method*/

public class QuickSort {
	
	/**
	 * partitions the array by putting all the values lesser than 
	 * 'left' to one side and putting all the values higher than left 
	 * to the other 'right' side
	 * 
	 * @param a: an array
	 * @param left: first element to implement partition on
	 * @param right: last element to implement partition on
	 * @return: the new index at which left is placed 
	 */
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
	
	/**
	 * sorts an array of integers in an ascending order by
	 * calling the quicksortKernel 
	 * @param a[]: an array
	 */
	public static void quicksort (int a[]) {
		if (a.length != 0) 
		quicksortKernel(a, 0, a.length-1);
	}
	
	/**
	 * 
	 * @param a[] : array
	 * @param left : left index 
	 * @param right: right index
	 * @return 0 if the array a[] is sorted
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
				quicksortKernel(a, left, index);
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
	
	/**
	 * main testing program
	 * @param args not used
	 */
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
		
		//testing with negative numbers
		int [] arr6 = {100, -5, 0, 10, -30, 40, 50, -60, 70, -80, 90};
		
		//testing with only one element in the array
		int [] arr7 = {7};
		
		//testing with maximum value at the start
		int [] arr8 = {9, 5, 3, 1, 7};
		
		quicksort(arr1);
		quicksort(arr2);
		quicksort(arr3);
		quicksort(arr4);
		quicksort(arr5);
		quicksort(arr6);
		quicksort(arr6);
		quicksort(arr7);
		quicksort(arr8);
		
		System.out.println("Sorted array : ");
		System.out.print("{");
		for (int i= 0; i < arr1.length-1; i++) {
			System.out.print(arr1[i] + ", ") ;
		}
		System.out.print(arr1[arr1.length-1] + "} \n");
		
		System.out.println("Sorted array 2: ");
		System.out.print("{");
		for (int i= 0; i < arr2.length-1; i++) {
			System.out.print(arr2[i] + ", ");
		}
		System.out.print(arr1[arr2.length-1] + "} ");
		
		System.out.println("\nSorted array 3: ");
		for (int i= 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + ", ");
		}
		
		System.out.println("\nSorted array 4: ");
		System.out.print("{");
		for (int i= 0; i < arr4.length-1; i++) {
			System.out.print(arr4[i] + ", ");
		}
		System.out.print(arr4[arr4.length-1] + "} ");
		
		System.out.println("\nSorted array 5: ");
		System.out.print("{");
		for (int i= 0; i < arr5.length-1; i++) {
			System.out.print(arr5[i] + ", ");
		}
		System.out.print(arr5[arr5.length-1] + "} ");
		
		System.out.println("\nSorted array 6: ");
		System.out.print("{");
		for (int i= 0; i < arr6.length-1; i++) {
			System.out.print(arr6[i] + ", ");
		}
		System.out.print(arr6[arr6.length-1] + "} ");
		
		System.out.println("\nSorted array 7: ");
		System.out.print("{");
		for (int i= 0; i < arr7.length-1; i++) {
			System.out.print(arr7[i] + ", ");
		}
		System.out.print(arr7[arr7.length-1] + "} ");
		
		System.out.println("\nSorted array 8: ");
		System.out.print("{");
		for (int i= 0; i < arr8.length-1; i++) {
			System.out.print(arr8[i] + ", ");
		}
		System.out.print(arr8[arr8.length-1] + "} ");
	}
}


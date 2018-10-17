package loopInvariants;

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
		quicksortKernel(a, 0, n-1);
	}
	
	/*
	 * @param : a[] : array 
	 * 		   left  : left index of the array
	 *         right: the right most index of the array 
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
		int [] arr = {70, 80, 30, 90, 40, 60, 50, 10};
		quicksort(arr, arr.length);
		System.out.println("Sorted array: ");
		System.out.print("{");
		for (int i= 0; i < arr.length-1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.print(arr[arr.length-1] + "} ");
	}
}

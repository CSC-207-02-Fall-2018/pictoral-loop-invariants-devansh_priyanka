package loopInvariants;

public class Partition {
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
	 * finds the kth smallest element in an array
	 * @param a[] : an array
	 * @param n: length of the array
	 * @param k: the number whose smallest value the user wants to find
	 * @return the selectKernel helper procedure
	 */
	public static int select (int a[], int n, int k) {
		return selectKernel(a, k, 0, n-1);
	}
	
	/**
	 * a helper procedure to select that finds the kth smallest
	 * element in an array
	 * @param a[] : an array
	 * @param k: the number whose smallest value the user wants to find
	 * @param left: the left index of the array
	 * @param right: the right index of the array
	 * @return small : the kth smallest value in the array
	 */
	public static int selectKernel (int a[], int k, int left, int right) {
		int pos= k-1;
		int middle = 0;
		int small = 0;
		
		if(right == 0) {
			small= a[pos];
		}
		else {
			middle = partition(a, left, right);
			if(pos == middle) {
				return a[pos];
			}
			//calls selectKernel on the left part of the array from the left 
			// index to the middle
			else if (k <= middle) {
				small = selectKernel (a, k, left, middle-1);
			}
			
			//calls selectKernel on the right part of the array from the middle
			// to the right index
			else if (k >= middle) {
				small = selectKernel (a, k, middle+1, right);
			} 
		}
		return small;
	}
	
	/**
	 * finds the median value of an array 
	 * @param a[] : an array
	 * @param n: length of an array
	 * @return : the median value
	 */
	public static int median (int a[], int n) {
		int median = 0;
		
		//finds the median if an array has odd number of elements
		if(n%2 == 1) {
			int middlePos = n/2;
			median = select(a, n, middlePos +1);
		}
		//finds the median if an array has an even number of elements
		else {
			int middlePos1 = n/2 - 1;
			int middlePos2 = (n/2);
			//finds the average of the two elements that fall in the middle of the array
			median = (select(a, n, middlePos1 + 1 ) + select(a, n, middlePos2 + 1)) / 2;
		}
		return median;
	}
	
	public static void main (String args[]) {
		//testing with a random set of integers
		int [] arr = {70, 80, 30, 90, 40, 60, 50, 10, 20, 0};
		int k = 6;
		System.out.println(k+"th smallest: " + select(arr, arr.length, k));
		System.out.println("Median: " + median(arr, arr.length));
		
		//testing with a sorted array 
		int [] arr1 = {10, 30, 40, 50, 60, 70, 80, 90};
		System.out.println(k+"th smallest: " + select(arr1, arr1.length, k));
		System.out.println("Median: " + median(arr1, arr1.length));
				
		//testing with a random set of integers
		int [] arr2 = {60, 70, 100, 5, 3, 4, 1, 9};
		System.out.println(k+"th smallest: " + select(arr2, arr2.length, k));
		System.out.println("Median: " + median(arr2, arr2.length));
				
		//testing with an empty array 
		int [] arr3 = {1};
		int j = 1;
		System.out.println(j+"th smallest: " + select(arr3, arr3.length, j));
		System.out.println("Median: " + median(arr3, arr3.length));
		
		//testing with the minimum value at the start of the array
		int [] arr4 = {1, 70, 100, 5, 3, 4, 2, 9};
		System.out.println(k+"th smallest: " + select(arr4, arr4.length, k));
		System.out.println("Median: " + median(arr4, arr4.length));
		
		//testing with the minimum value at the end of an array
		int [] arr5 = {60, 70, 100, 5, 3, 40, 2, 1};
		System.out.println(k+"th smallest: " + select(arr5, arr5.length, k));
		System.out.println("Median: " + median(arr5, arr5.length));
	}
}

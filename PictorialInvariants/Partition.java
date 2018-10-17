package loopInvariants;

public class Partition {
	public static int partition (int a[], int left, int right) {
		int l_spot= left +1;
		int pivot = a[left];
		int r_spot = right;
		int temp = 0;
		while (l_spot <= r_spot) {
			if (a[l_spot] <= pivot) {
				l_spot++;
			}
			if (a[r_spot] >= pivot) {
				r_spot--;
			}
			if ((l_spot <= r_spot) && (a[l_spot] > pivot) && (a[r_spot] < pivot)) {
				// swap(a[l_spot], a[r_spot]);
				temp = a[l_spot];
				a[l_spot] = a[r_spot];
				a[r_spot] = temp;
			}
		}
		a[left] = a[r_spot];
		a[r_spot]= pivot;
		return r_spot;
	}
	
	public static int select (int a[], int n, int k) {
		return selectKernel(a, k, 0, n-1);
	}
	
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
			else if (k <= middle) {
				small = selectKernel (a, k, left, middle-1);
			}
			else if (k >= middle) {
				small = selectKernel (a, k, middle+1, right);
			} 
		}
		return small;
	}
	
	public static int median (int a[], int n) {
		int median = 0;
		if(n%2 == 1) {
			int middlePos = n/2;
			median = select(a, n, middlePos +1);
		}
		else {
			int middlePos1 = n/2 - 1;
			int middlePos2 = (n/2);
			median = (select(a, n, middlePos1 + 1 ) + select(a, n, middlePos2 + 1)) / 2;
		}
		return median;
	}
	
	public static void main (String args[]) {
		int [] arr = {70, 80, 30, 90, 40, 60, 50, 10, 20, 0};
		int k = 6;
		System.out.println(k+"th smallest: " + select(arr, arr.length, k));
		System.out.println("Median: " + median(arr, arr.length));
	}
}

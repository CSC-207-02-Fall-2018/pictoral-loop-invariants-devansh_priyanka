package loopInvariants;

public class DutchNationalFlag {

	public static void swap (int a[], int pos1, int pos2) {
		int temp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = temp;
	}
	
	public static void variantA (int a[]) {
		int length = a.length;
		int white1 = 0;
		int blue1 = 0;
		int unexamined1 = 0;
		while(unexamined1 < length) {
			if (a[unexamined1] == 2) {
				unexamined1++;
			}
			else if (a[unexamined1] == 1) {
				swap (a, unexamined1, blue1);
				unexamined1++;
				blue1++;
			}
			else if (a[unexamined1] == 0) {
				swap (a, unexamined1, white1);
				swap (a, unexamined1, blue1);
				unexamined1++;
				blue1++;
				white1++;
			}
		}
	}
	
	public static void variantB (int a[]) {
		int length = a.length;
		int white1 = 0;
		int unexamined1 = 0;
		int blue1 = length;
		while(unexamined1 < blue1) {
			if (a[unexamined1] == 1) {
				unexamined1++;
			}
			else if (a[unexamined1] == 0) {
				swap (a, unexamined1, white1);
				unexamined1++;
				white1++;
			}
			else if (a[unexamined1] == 2) {
				swap (a, unexamined1, blue1-1);
				blue1--;
			}
		}
	}
	
	public static void main (String args[]) {
		int [] arr1 = {1, 2, 0, 2, 1, 2, 1, 0, 0};
		int [] arr2 = {1, 0, 0, 2, 1, 1, 1, 0, 0, 2, 2, 2, 2};
		int [] arr3 = {};
		int [] arr4 = {2, 1, 0};
		variantA(arr1);
		variantB(arr2);
		variantA(arr3);
		variantB(arr4);
		System.out.println("Sorted Dutch National Flag using Invariant A: ");
		for (int i= 0; i<arr1.length; i++) {
			System.out.print(arr1[i]);
		}
		System.out.println();
		System.out.println("Sorted Dutch National Flag using Invariant B: ");
		for (int i= 0; i<arr2.length; i++) {
			System.out.print(arr2[i]);
		}
		System.out.println();
		System.out.println("Sorted Dutch National Flag using Invariant B: ");
		for (int i= 0; i<arr3.length; i++) {
			System.out.print(arr3[i]);
		}
		System.out.println();
		System.out.println("Sorted Dutch National Flag using Invariant B: ");
		for (int i= 0; i<arr4.length; i++) {
			System.out.print(arr4[i]);
		}
	}
}

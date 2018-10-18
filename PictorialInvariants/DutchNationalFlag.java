package loopInvariants;

public class DutchNationalFlag {
    
	/**
	 * swaps the value in the pos1 index of an array with 
	 * the value in pos2 index of an array
	 * @param a[] : array
	 * @param pos1: one index of a value in an array
	 * @param pos2: another index of another value in an array
	 */
	public static void swap (int a[], int pos1, int pos2) {
		int temp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = temp;
	}
	
	/**
	 * sorts the "colors" in an array according to the 
	 * color of the Dutch national flag
	 * 
	 * variable white1 is the first index after red
	 * the variable blue1 is the first index after white, 
	 * and the variable unexamined1 is the first index after blue.
	 * 
	 *  0 = red
	 *  1 = white
	 *  2 = blue
	 * @param a[] : array of the "colors"
	 */
	public static void variantA (int a[]) {
		int length = a.length;
		int white1 = 0;
		int blue1 = 0;
		int unexamined1 = 0;
		
		//loops until the end of the array
		while(unexamined1 < length) {
			if (a[unexamined1] == 2) {
				unexamined1++;
			}
			/* if first index of unexamined is white, this swaps the first 
			 * index of the "blue" part of the flag with the first index of unexamined*/
			else if (a[unexamined1] == 1) {
				swap (a, unexamined1, blue1);
				unexamined1++;
				blue1++;
			}
			
			/* if first index of unexamined is red, 
			 * swaps the first index of the "white" part of the flag with
			 *  the first index of unexamined
			 *  
			 *  swaps the first index of the "blue" part of the flag with 
			 *  the first index of unexamined*/
			else if (a[unexamined1] == 0) {
				swap (a, unexamined1, white1);
				swap (a, unexamined1, blue1);
				unexamined1++;
				blue1++;
				white1++;
			}
		}
	}
	
	/**
	 * sorts the "colors" in an array according to the 
	 * color of the Dutch national flag
	 * 
	 * variable white1 is the first index after red,
	 * the variable unexamined1 is the first index after white, 
	 * and the variable blue1 is the first index after unexamined.
	 * 
	 *  0 = red
	 *  1 = white
	 *  2 = blue
	 * @param a[] : array of the "colors"
	 */
	public static void variantB (int a[]) {
		int length = a.length;
		int white1 = 0;
		int unexamined1 = 0;
		int blue1 = length;
		//loops until the end of the array
		while(unexamined1 < blue1) {
			if (a[unexamined1] == 1) {
				unexamined1++;
			}
			/* if first index of unexamined is red, this swaps the first 
			 * index of the "white" part of the flag with the first index of unexamined*/
			else if (a[unexamined1] == 0) {
				swap (a, unexamined1, white1);
				unexamined1++;
				white1++;
			}
			/* if first index of unexamined is blue, this swaps the last 
			 * index of the "blue" part of the flag with the first index of unexamined*/
			else if (a[unexamined1] == 2) {
				swap (a, unexamined1, blue1-1);
				blue1--;
			}
		}
	}
	
	public static void main (String args[]) {
		
		//testing with a random array
		int [] arr1 = {1, 2, 0, 2, 1, 2, 1, 0, 0};
		int [] arr2 = {1, 0, 0, 2, 1, 1, 1, 0, 0, 2, 2, 2, 2};
		
		//testing with a null array
		int [] arr3 = {};
		int [] arr5 = {};
		
		//testing with a sorted array
		int [] arr4 = {0, 1, 2};
		int [] arr6 = {0, 1, 2};
		
		//testing with the minimum value at the start
		int [] arr7 = {0, 1, 2, 0};
		int [] arr8 = {0, 1, 2, 0};
		
		variantA(arr1);
		variantB(arr2);
		variantA(arr3);
		variantB(arr4);
		variantB(arr5);
		variantA(arr6);
		variantA(arr7);
		variantB(arr8);
		
		//prints out the tests
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
		System.out.println("Sorted Dutch National Flag using Invariant A: ");
		for (int i= 0; i<arr3.length; i++) {
			System.out.print(arr3[i]);
		}
		System.out.println();
		System.out.println("Sorted Dutch National Flag using Invariant B: ");
		for (int i= 0; i<arr4.length; i++) {
			System.out.print(arr4[i]);
		}
		System.out.println("\nSorted Dutch National Flag using Invariant B: ");
		for (int i= 0; i<arr5.length; i++) {
			System.out.print(arr5[i]);
		}
		System.out.println("\nSorted Dutch National Flag using Invariant B: ");
		for (int i= 0; i<arr6.length; i++) {
			System.out.print(arr6[i]);
		}
		System.out.println("\nSorted Dutch National Flag using Invariant B: ");
		for (int i= 0; i<arr7.length; i++) {
			System.out.print(arr7[i]);
		}
		System.out.println("\nSorted Dutch National Flag using Invariant B: ");
		for (int i= 0; i<arr8.length; i++) {
			System.out.print(arr8[i]);
		}
	}
}

/**
 * Group Members: Neal Jamieson, James Gregory, Landdon Squiers
 * Class: CSCI_3342_002
 * Assignment: Exploration 1 
 */

package Exploration2;

import java.util.Scanner;
import java.util.Random;


/**
 * @author Neal Jamieson
 * 
 * This class performs a merge sort on a given integer array
 */
public class Mergesort {
	// static variable to count the number of basic operations
	private static int runCount = 0;
	
	/**
	 * The main method in this class is used to test the algorithm outside of the experiment environment. This is primarily used for debugging purposes.
	 * @param args the command line arguments passed in at runtime
	 */
	public static void main(String[] args) {
		// obtain the input size from the user
		System.out.print("Enter an integer (>= 1): ");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		
		// create an array of size equal to the input size
		int[] A = new int[n];
		
		// fill the array with random integers
		Random num = new Random();
		for (int i = 0; i < n; i++) {
			A[i] = num.nextInt();
		}
		
		// output the unsorted array to the console
		System.out.print("The original array: ");
		for (int j: A) {
			System.out.print(j + " ");
		}
		System.out.println();
		
		// sort the array
		mergesort(A);
		
		// output the sorted array to the console
		System.out.print("The sorted array: ");
		for (int k: A) {
			System.out.print(k + " ");
		}
		System.out.println();
	}
	
	/**
	 * Performs a merge sort recursively on a given integer array
	 * @param A The integer array to perform the merge sort on
	 */
	public static void mergesort(int[] A) {
		// determine the length of the arrray
		int n = A.length;
		
		// if there is more than one element in the array split it
		if (n > 1) {
			runCount++;
			// create array B that contains the first half of array A
			int[]B = new int[Math.floorDiv(n, 2)];
			for (int i = 0; i < Math.floorDiv(n, 2); i++) {
				B[i] = A[i];
			}
			
			// create array C that contains the second half of array A
			int[]C = new int[n - B.length];
			int k = 0;
			for (int j = Math.floorDiv(n, 2); j < n; j++) {
				C[k] = A[j];
				k++;
			}
			
			// perform a merge sort on arrays B and C
			mergesort(B);
			mergesort(C);
			
			// merge the sorted arrays B and C into array A
			merge(B,C,A);
		 
		}
	}
	
	/**
	 * merges the first two input arrays into a third array
	 * @param B the first array to merge
	 * @param C the second array to merge
	 * @param A the destination array
	 */
	public static void  merge(int[] B, int[] C, int[] A) {
		// declare variables i,j, and k to track loop positions
		int i = 0;
		int j = 0;
		int k = 0;
		
		// declare variables p and q to track the length of arrays B and C
		int p = B.length;
		int q = C.length;
		
		// merge the arrays together into array A
		while (i < p && j < q) {
			if (B[i] <= C[j]) {
				A[k] = B[i];
				i++;
			}
			else {
				A[k] = C[j];
				j++;
			}
			k++;
		}
		if (i==p) {
			while(k<(p+q) && j < q) {
				A[k] = C[j];
				k++;
				j++;
			}
		}
		else {
			while(k<(p+q) && i < p) {
				A[k] = B[i];
				k++;
				i++;
			}
		}
	}
	
	/**
	 * Resets the counter variable to zero
	 */
	public static void resetRunCount() {
		runCount = 0;
	}
	
	/**
	 * gets the current value of the counter variable
	 * @return returns the value of the counter variable
	 */
	public static int getRunCount() {
		return runCount;
	}
}

/**
 * Group Members: Neal Jamieson, James Gregory, Landdon Squiers
 * Class: CSCI_3342_002
 * Assignment: Exploration 1 
 */

package Exploration2;

import java.util.Random;
import java.util.Scanner;


/**
 * @author Neal Jamieson
 * 
 * This class performs a bubble sort on a given integer array
 */
public class Bubblesort {
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
		bubblesort(A);
		
		// output the sorted array to the console
		System.out.print("The sorted array: ");
		for (int k: A) {
			System.out.print(k + " ");
		}
		System.out.println();
	}	
	
	/**
	 * Performs a bubble sort iteratively on a given integer array
	 * @param A The integer array to perform the bubble sort on
	 */
	public static void bubblesort(int[] A) {
		// declare variable n to track array length
		int n = A.length;
		
		// iterate through the array and perform the bubble sort
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-1-i; j++) {
				if (A[j+1] < A[j]) {
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
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

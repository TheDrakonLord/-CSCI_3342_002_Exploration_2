/**
 * Group Members: Neal Jamieson, James Gregory, Landdon Squiers
 * Class: CSCI_3342_002
 * Assignment: Exploration 2 
 */


package Exploration2;

import java.util.Random;

/**
 * @author Neal Jamieson
 * 
 * This class takes the mergesort and bubblesort algorithms and tests them based on a given set of input sizes.
 */
public class Test {

	/**
	 * evaluates the given algorithms for specified input sizes
	 * @param args command line arguments passed in at execution
	 */
	public static void main(String[] args) {
		
		// list of cases to test (first value is always dummy)
		int[] testCases = {0,2,8,16,32,64,96,128,160,192,224,256};
		
		//test all of the test cases
		for(int i:testCases) {
			checkMerge(i);
			checkBubble(i);
		}

	}
	
	/**
	 * runs the mergesort algorithm and reports the number of times the basic operation occurred and how long it took for the algorithm to complete. Resets the counter variable when finished.
	 * @param n the input size on which to evaluate the algorithm
	 */
	private static void checkMerge(int n) {
		int[] A = new int[n];
		Random num = new Random();
		for (int i = 0; i < n; i++) {
			A[i] = num.nextInt();
		}
		
/*		String originalArray;
*		for (int j: A) {
*			originalArray = originalArray + j + " ";
*		}
*/

		//System nanoTimer nanosecond resolution
		long startTime = 0;
		long stopTime = 0;
		long overTime = 0;
		//nano second -- clock resolution
		startTime = System.nanoTime();
		stopTime = System.nanoTime();
		overTime = stopTime - startTime;
		
		//Start timer for execution timing
		startTime = System.nanoTime();
		
		//Execute algorithm to be tested
		Mergesort.mergesort(A);
				
		
		stopTime = System.nanoTime();
		long time = stopTime-startTime-overTime;
		
/*		String sortedArray;
*		for (int k: A) {
*			sortedArray = sortedArray + k + " ";
*		}
*/
		
		//Display the results and reset the counter
		System.out.println(String.format("Mergesort took an input of %d and ran %d times and took %d nanoseconds to complete.", n, Mergesort.getRunCount(), time));
		Mergesort.resetRunCount();
	}
	
	
	/**
	 * runs the bubblesort algorithm and reports the number of times the basic operation occurred and how long it took for the algorithm to complete. Resets the counter variable when finished.
	 * @param n the input size on which to evaluate the algorithm
	 */
	private static void checkBubble(int n) {
		int[] A = new int[n];
		Random num = new Random();
		for (int i = 0; i < n; i++) {
			A[i] = num.nextInt();
		}

		//System nanoTimer nanosecond resolution
		long startTime = 0;
		long stopTime = 0;
		long overTime = 0;
		//nano second -- clock resolution
		startTime = System.nanoTime();
		stopTime = System.nanoTime();
		overTime = stopTime - startTime;
		
		//Start timer for execution timing
		startTime = System.nanoTime();
		
		//Execute algorithm to be tested
		Bubblesort.bubblesort(A);
				
		
		stopTime = System.nanoTime();
		long time = stopTime-startTime-overTime;
		
		
		//Display the results and reset the counter
		System.out.println(String.format("Bubblesort took an input of %d and ran %d times and took %d nanoseconds to complete.", n, Bubblesort.getRunCount(), time));
		Bubblesort.resetRunCount();
	}
}

package array;

import java.util.HashSet;
import java.util.Set;

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Array
 *******************************************************/

/*Given an array A[] and a number x, check for pair in A[] with sum as x*/
public class PairOfASum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 4, 45, 6, 10, -8, 8};
		findPair(arr, 0);
	}

	private static void findPair(int[] arr, int n) {
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<arr.length; i++) {
			int complement = n - arr[i];
			if(set.contains(complement)) {
				System.out.println("pair :: "+complement+", "+arr[i]);
			}
			set.add(arr[i]);
		}
	}

}

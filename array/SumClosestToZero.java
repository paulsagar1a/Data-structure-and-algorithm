/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category array
 *******************************************************/

/*Two elements whose sum is closest to zero
An Array of integers is given, both +ve and -ve. 
You need to find the two elements such that their sum is closest to zero.*/

package array;

import java.util.Arrays;

public class SumClosestToZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 60, -10, 70, -80, 85};
		closestToZeroPair(arr);
	}

	private static void closestToZeroPair(int[] arr) {
		// TODO Auto-generated method stub
		//sort the array first
		Arrays.sort(arr); //complexity O(nlogn)
		int left = 0, right = arr.length - 1;
		int minLeft = 0, minRight = arr.length - 1;
		int sum = 0, minSum = 999999;
		while(left < right) {
			sum = arr[left] + arr[right];
			if(Math.abs(sum) < Math.abs(minSum)) {
				minSum = sum;
				minLeft = left;
				minRight = right;
			}
			if(sum < 0)
				left++;
			else
				right--;
		}
		System.out.println("The closest pair is ("+arr[minLeft]+", "+arr[minRight]+")");
	}

}
/*Time Complexity: complexity to sort + complexity of finding the optimum pair = O(nlogn) + O(n) = O(nlogn)*/

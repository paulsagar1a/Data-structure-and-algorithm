package array;

import java.util.Arrays;

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Array
 *******************************************************/

/*Pythagorean Triplet in an array. Given an array of integers, 
write a function that returns true if 
there is a triplet (a, b, c) that satisfies a2 + b2 = c2*/
public class PythagoreanTriplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4, 3, 6, 1, 5};
		System.out.println(presentTriplet(arr));
		
		//Time complexity = O(n^2)
	}
	
	public static boolean presentTriplet(int[] arr) {
		int len = arr.length;
		for(int i=0; i<len; i++) {
			arr[i] = arr[i] * arr[i];
		}
		Arrays.sort(arr);
		for(int i=len-1; i>=0; i--) {
			int s = 0, e = i;
			while(s<e) {
				if(arr[s] + arr[e] == arr[i]) {
					return true;
				} else if( arr[s] + arr[e] > arr[i]) {
					e--;
				} else {
					s++;
				}
			}
		}
		return false;
	}

}

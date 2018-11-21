/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category array
 *******************************************************/

/*Chocolate Distribution Problem

Given an array of n integers where each value represents number 
of chocolates in a packet. Each packet can have variable number 
of chocolates. There are m students, the task is to distribute 
chocolate packets such that:

   1. Each student gets one packet.
   2. The difference between the number of chocolates in packet 
   with maximum chocolates and packet with minimum chocolates given 
   to the students is minimum.*/

package array;

import java.util.Arrays;

public class ChocolateDistribution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3, 4, 1, 9, 50, 7, 9, 12};
		int students = 5;
		int packets = arr.length;
		ChocolateDistribution obj = new ChocolateDistribution();
		int minDiff = obj.findMinimumDifference(arr, students, packets);
		System.out.println("Minimum difference is: "+minDiff);
	}

	private int findMinimumDifference(int[] arr, int students, int packets) {
		//if students=0 or packets=0
		if(students == 0 || packets == 0)
			return 0;
		//number of students can not be greater than number of chocolate packets
		if(students > packets)
			return -1;
		
		//sort the array
		Arrays.sort(arr);
		
		//find the sub-array of size 'students' such that difference
		//between last and first sub-array is minimum
		int minDifference = Integer.MAX_VALUE;
		int first = 0, last = 0;
		for(int i=0; i+students-1 < packets; i++) {
			int difference = arr[i+students-1] - arr[i];
			if(difference < minDifference) {
				minDifference = difference;
				first = i;
				last = i+students-1;
			}
		}
		return arr[last]-arr[first];
	}

}

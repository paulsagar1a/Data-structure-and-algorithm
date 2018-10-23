package array;

import java.util.Arrays;

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Array
 *******************************************************/

/*Minimum Number of Platforms Required for a Railway/Bus Station
Given arrival and departure times of all trains that reach a railway 
station, find the minimum number of platforms required for the railway 
station so that no train waits.
We are given two arrays which represent arrival and departure times of trains that stop*/
public class MinimumPlatform {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrival = {910, 940, 950, 1110, 1500, 1800, 2020};
		int[] departure = {930, 1200, 1120, 1130, 1900, 2010};
		System.out.println("Minimum number of platforms required:");
		System.out.println(findRequiredPlatforms(arrival, departure));
	}

	private static int findRequiredPlatforms(int[] arrival, int[] departure) {
		// TODO Auto-generated method stub
		//sort the two arrays
		Arrays.sort(arrival);
		Arrays.sort(departure);
		int reqPlatform = 0;
		int tempPlatform = 0;
		int arrIndex = 0, depIndex = 0;
		int arrLen = arrival.length;
		int depLen = departure.length;
		while(arrIndex < arrLen && depIndex < depLen) {
			if(arrival[arrIndex] <= departure[depIndex]) {
				tempPlatform ++;
				if(tempPlatform > reqPlatform)
					reqPlatform = tempPlatform;
				arrIndex ++;
			} else {
				tempPlatform --;
				depIndex ++;
			}
		}
		//if some trains came but did not left from the station
		if(arrIndex < arrLen) {
			reqPlatform++;
		}
		return reqPlatform;
	}

}

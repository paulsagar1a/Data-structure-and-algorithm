package array;

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Array
 *******************************************************/

/*Trapping Rain Water
Given n non-negative integers representing an 
elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.*/
public class TrapRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4, 0, 3, 0, 5, 2, 0, 3, 4, 0};
		System.out.println(getTrappedWater(arr));
	}

	private static int getTrappedWater(int[] arr) {
		// TODO Auto-generated method stub
		int len = arr.length;
		int trappedWater = 0;
		if(len == 0 || len == 1 || len == 2) {
			return trappedWater;
		}
		int leftMax = 0, rightMax = 0;
		int left = 0, right = len-1;
		while(left <= right) {
			if(arr[left] >= arr[right]) {
				//start from right
				if(rightMax < arr [right]) {
					rightMax = arr[right];
				} else {
					trappedWater += rightMax - arr[right];
				}
				right--;
			} else {
				//start from left
				if(leftMax < arr[left]) {
					leftMax = arr[left];
				} else {
					trappedWater += leftMax - arr[left];
				}
				left++;
			}
		}
		return trappedWater;
	}

}

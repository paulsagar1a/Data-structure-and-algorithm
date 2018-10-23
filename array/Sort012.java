package array;

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Array
 *******************************************************/

/*Given an array of 0s, 1s and 2s. Sort the array.
For example- given arr = {0, 2, 1, 0, 1, 2}
expected output arr = {0, 0, 1, 1, 2, 2}*/
public class Sort012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,1,0,0,0,2,1,0,2,1};
		arr = sort012(arr);
		for(int i : arr) {
			System.out.println(i);
		}
		//Time complexity = O(n)
		//Space complexity = O(1)
	}

	private static int[] sort012(int[] arr) {
		// TODO Auto-generated method stub
		int lo = 0, mid = 0, hi = arr.length-1;
		
		while(mid <= hi) {
			switch(arr[mid]) {
			case 0:
				swap(arr, lo, mid);
				lo++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(arr, mid, hi);
				hi--;
			}
		}
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}

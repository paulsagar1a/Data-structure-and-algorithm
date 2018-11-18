/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category array
 *******************************************************/

/*Find the smallest missing number

Given a sorted array of n distinct integers where each integer 
is in the range from 0 to m-1 and m > n. Find the smallest number 
that is missing from the array. */

package array;

public class SmallestMissing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallestMissing obj = new SmallestMissing();
		int arr[] = {0, 1, 2, 3, 6, 7, 9, 10};
		int smallest = obj.findSmallest(arr, 0, arr.length-1);
		System.out.println(smallest);
	}

	private int findSmallest(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if(start > end)
			return end+1;
		if(start != arr[start])
			return start;
		int mid = (start + end)/2;
		if(arr[mid] == mid)
			return findSmallest(arr, mid+1, end);
		return findSmallest(arr, start, mid);
	}

}

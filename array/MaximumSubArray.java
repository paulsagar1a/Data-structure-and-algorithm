package array;

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Data Structure Array
 *******************************************************/
/*Given an arry of integers, find contigious subarray within it which has largesr sum*/
//this is also called Kadane's algo
public class MaximumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		findMaxSubArray(arr);
		/*Output:
		Maximum sum subarray = 6
		Subarray starts from index 3 to 6*/
	}

	private static void findMaxSubArray(int[] arr) {
		// TODO Auto-generated method stub
		int sum = 0;
		int max = 0;
		int start = 0, end = 0, s = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			if(sum > max) {
				max = sum;
				start = s;
				end = i;
			}
			if(sum < 0) {
				sum = 0;
				s = i+1;
			}
		}
		System.out.println("Maximum sum subarray = "+max);
		System.out.println("Subarray starts from index "+start+" to "+end);
	}

}

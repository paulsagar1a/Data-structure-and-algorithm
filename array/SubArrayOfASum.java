package array;

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Array
 *******************************************************/

/*Find subarray with given sum*/
public class SubArrayOfASum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 4, 1, 6, 14, 0, 3, 5, 12};
		int sum = 29;
		findSubArray(arr,sum);
	}

	private static void findSubArray(int[] arr, int n) {
		// TODO Auto-generated method stub
		int sum = 0;
		int start = 0, end = 0, s = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			while(sum > n) {
				sum -= arr[s];
				s++;
			}
			if(sum == n) {
				start = s;
				end = i;
				System.out.println("sub-array: start= "+start+" end="+end);
				return;
			}
		}
		System.out.println("No sub-array found.");
	}

}

package dynamic_programming;

public class LongestSubsequenceLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3, 4, -1, 0, 6, 2, 3};
		int n = arr.length;
		//longest increasing subsequence length
		int lisLength = findLongestLen(arr, n);
		System.out.println("Longest increasing subsequence length= "+lisLength);
	}

	private static int findLongestLen(int[] arr, int n) {
		int[] temp = new int[n];
		int lisLength = 0;
		for(int i=0; i<n; i++) {
			temp[i] = 1;
		}
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if((arr[i] > arr[j]) && (temp[j]+1 > temp[i]))
						temp[i] = temp[j]+1;
			}
		}
		for(int i=0; i<n; i++) {
			if(lisLength < temp[i])
				lisLength = temp[i];
		}
		return lisLength;
	}

}

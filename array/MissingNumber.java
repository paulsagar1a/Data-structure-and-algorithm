package array;


/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Array
 *******************************************************/

/*Find the Missing Number
You are given a list of n-1 integers and these integers are in the range of 1 to n. 
There are no duplicates in list. One of the integers is missing in the list. 
Write an efficient code to find the missing integer.
Example :
I/P    [1, 2, 4, ,6, 3, 7, 8]
O/P    5*/

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2, 4, 5, 6, 1, 9, 7, 3};
		System.out.println(findMissingFromTheSeries(arr));
	}

	private static int findMissingFromTheSeries(int[] arr) {
		// TODO Auto-generated method stub
		int len = arr.length;
		if(len == 0 || len == 1)
			return -1;
		System.out.println("missing");
		//find the total of the series to the max element
		int total = ((len+1)*(len+2))/2; //sum of 1st n natural number = (n*(n+1))/2
		//find the missing one
		for(int i=0; i<arr.length; i++) {
			total -= arr[i];
		}
		return total;
	}

}

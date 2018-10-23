package array;

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Array
 *******************************************************/

/*Given an array, find the equilibrium point of the array:
	for example array = {2, 3, 7, 1, 8, 4, 2}
	equilibrium point = 3*/
public class EquilibriumPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 1, 4, 1, 2, 3, 5, 2, 3};
		System.out.println(findEquilibrium(arr));
	}

	private static int findEquilibrium(int[] arr) {
		// TODO Auto-generated method stub
		int total = 0;
		int leftSum = 0;
		
		if(arr.length == 0 || arr.length == 1 || arr.length == 2)
			return -1;
		
		//add all the elements
		for(int i=0; i< arr.length; i++) {
			total += arr[i];
		}
		
		for(int i=0; i<arr.length; i++) {
			total -= arr[i];
			if(total == leftSum)
				return i;
			leftSum += arr[i];
		}
		return -1;
	}

}

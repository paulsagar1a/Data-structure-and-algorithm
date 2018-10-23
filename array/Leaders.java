package array;

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Array
 *******************************************************/

/*Find all the leaders of an array*/
public class Leaders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 8, 9, 4, 1, 5, 2};
		printLeaders(arr);
	}

	private static void printLeaders(int[] arr) {
		// TODO Auto-generated method stub
		int len = arr.length;
		int leader = arr[len-1];//last element is always a leader
		System.out.println(leader);
		for(int i=len-2; i>=0; i--) {
			if(arr[i] > leader) {
				leader = arr[i];
				System.out.println(leader);
			}
		}
	}

}

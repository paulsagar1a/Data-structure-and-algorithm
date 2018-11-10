/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category array
 *******************************************************/
//given an array, segregate this array in order of evens and odds
package array;

public class SegregateEvenOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		segregateEvenOdd(arr);
	}

	private static void segregateEvenOdd(int[] arr) {
		// TODO Auto-generated method stub
		int len = arr.length;
		int p = -1;
		
		for(int i = 0; i < len; i++) {
			//if arr[i] = even then swap(arr[p++], arr[i])
			if(arr[i] % 2 == 0) {
				//swap
				p++;
				int temp = arr[p];
				arr[p] = arr[i];
				arr[i] = temp;
			}
		}
		
		//print array
		for(int i = 0; i < len; i++) {
			System.out.print(arr[i]+ " ");
		}
	}

}

package array;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;
import java.util.List;

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Array
 *******************************************************/
/*Find the largest number of an array*/
public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 5, 7, 10, 3, 5, 9};
		System.out.println(findLargest(arr));
	}

	private static int findLargest(int[] arr) {
		// TODO Auto-generated method stub
		
		if(arr.length == 0)
			return -1;
		if(arr.length == 1)
			return arr[0];
		
		List<Integer> list = new ArrayList<>();
		for(int i=0; i< arr.length; i++) {
			list.add(arr[i]);
		}
		
		/*Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				if(arg0 > arg1) return -1;
				if(arg0 < arg1) return 1;
				return 0;
			}
			
		});*/
		Collections.sort(list, Collections.reverseOrder());//using predefined factory method
		return list.get(0);
	}

}

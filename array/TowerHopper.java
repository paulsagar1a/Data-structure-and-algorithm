package array;

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category String
 *******************************************************/

/*Minimum number of jumps to reach end
Given an array of integers where each element represents the max
number of steps that can be made forward from that element. Write
a function to return the minimum number of jumps to reach the end
of the array (starting from the first element). If an 
element is 0, then cannot move through that element.*/
public class TowerHopper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 3, 6, 1, 0, 9};
		System.out.println("Minimum jumps required to hop the towers are: "+minimumJumpRequired(arr));
	}

	private static int minimumJumpRequired(int[] arr) {
		// TODO Auto-generated method stub
		int jumpingPointer = arr.length;
		int jumpCount = 0;
		//start from the right most point
		while(jumpingPointer != 0) {
			jumpingPointer = getEstimatedPointer(arr, jumpingPointer);
			if(jumpingPointer == -1)
				return jumpingPointer;
			System.out.print("<-"+jumpingPointer);
			jumpCount++;
		}
		System.out.println("\n_______________________________________________");
		return jumpCount;
	}

	//method to get the next index from where jump can be started
	private static int getEstimatedPointer(int[] arr, int pointer) {
		// TODO Auto-generated method stub
		int jumpLength = 0;
		int nextPointer = -1;
		for(int i= pointer-1; i>=0; i--) {
			if(arr[i]-jumpLength > 0) {
				nextPointer = i;
			}
			jumpLength++;
		}
		return nextPointer;
	}

}

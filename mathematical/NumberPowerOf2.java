/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category mathematical
 *******************************************************/

//find a number whether it's power of 2
package mathematical;

public class NumberPowerOf2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(recursiveCheck(4));
		System.out.println(iterativeCheck(77));
	}

	private static boolean iterativeCheck(int n) {
		if(n == 0)
			return false;
		while(n != 1) {
			if(n%2 != 0)
				return false;
			n = n/2;
		}
		return true;
	}

	private static boolean recursiveCheck(int i) {
		return (i != 0) && (i&(i-1)) == 0;
	}

}

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category string
 *******************************************************/
//create a function to reverse a string recursively
package string;

public class ReverseRecursively {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "github";
		System.out.println("recursive string is: "+recursiveReverse(str));
	}

	private static String recursiveReverse(String str) {
		if(str.isEmpty()) {
			System.out.println("String is empty");
			return str;
		}
		System.out.println("String to be passed in recursive function: "+str.substring(1));
		return recursiveReverse(str.substring(1)) + str.charAt(0);
	}

}

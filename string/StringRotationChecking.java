/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category string
 *******************************************************/

/*Write a Program to check if strings are rotations of each 
other or not.
Write a program to check if two given String s1 and s2 are 
rotations of another. For example if s1 = "IndiaUSAEngland" 
and s2= "USAEnglandIndia" then your program should return true 
but if s2="IndiaEnglandUSA" then it should return false.*/

package string;

public class StringRotationChecking {

	public static void main(String[] args) {
		String original = "IndiaUSAEngland";
		String rotation = "USAEnglandIndia";
		System.out.println(checkRotation(original, rotation));
	}

	private static boolean checkRotation(String original, String rotation) {
		if(original.length() != rotation.length())
			return false;
		original = original.concat(original);
		return original.contains(rotation);
	}

}

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category string
 *******************************************************/

/*Pangram Checking
Given a string check if it is Pangram or not. A pangram is 
a sentence containing every letter in the English Alphabet.*/

package string;

public class Pangram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "The quick brown fox jumps over the lazy dog";
		System.out.println(checkPangram(str));
	}

	private static boolean checkPangram(String str) {
		boolean[] flag = new boolean[26];
		int i = 0;
		//iterate the string
		for(int j=0; j<str.length(); j++) {
			//check if j-th character belongs to A-Z
			if('A' <= str.charAt(j) && str.charAt(j) <= 'Z') {
				i = str.charAt(j) - 'A';
			//check if j-th character belongs to a-z
			} else if('a' <= str.charAt(j) && str.charAt(j) <= 'z') {
				i = str.charAt(j) - 'a';
			}
			//add true to the i-th index
			flag[i] = true;
		}
		//check if all index are true
		for(int k=0; k<26; k++) {
			if(flag[k] == false)
				return false;
		}
		return true;
	}

}

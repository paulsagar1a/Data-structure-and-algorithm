/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category String
 *******************************************************/

/*Given two strings, check whether two given strings are 
 * anagram of each other or not. An anagram of a string 
 * is another string that contains same characters, only 
 * the order of characters can be different. For example, 
 * “act” and “tac” are anagram of each other.*/
package string;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "Listen";
		String str2 = "Silent";
		System.out.println(checkAnagram(str1, str2));
	}

	private static boolean checkAnagram(String str1, String str2) {
		// TODO Auto-generated method stub
		
		int len1 = str1.length();
		int len2 = str2.length();
		if(len1 != len2) 
			return false;
		
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		char[] char1 = str1.toCharArray();
		char[] char2 = str2.toCharArray();
		
		Arrays.sort(char1);
		Arrays.sort(char2);
		
		for(int i=0; i < len1; i++) {
			if(char1[i] != char2[i])
				return false;
		}
		return true;
	}

}

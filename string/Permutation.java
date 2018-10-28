package string;

import java.util.HashSet;
import java.util.Set;

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category String
 *******************************************************/
//find the permutation of a given string
public class Permutation {
	static Set<String> set = new HashSet<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "FOX";
		permutation(str, 0, str.length()-1);
		System.out.println(set);
		/*Algorithm Paradigm: Backtracking
		Time Complexity: O(n*n!) 
		Note that there are n! permutations and
		it requires O(n) time to print a a permutation.*/
	}

	private static void permutation(String str, int lo, int hi) {
		// TODO Auto-generated method stub
		if(lo == hi) {
			set.add(str);
		} else {
			for(int i=lo; i<=hi; i++) {
				str = swap(str, lo, i);
				permutation(str, lo+1, hi);
				str = swap(str, lo, i);
			}
		}
	}

	private static String swap(String str, int i, int j) {
		// TODO Auto-generated method stub
		char temp;
		char[] charArr = str.toCharArray();
		temp = charArr[i];
		charArr[i] = charArr[j];
		charArr[j] = temp;
		return String.valueOf(charArr);
	}

}
